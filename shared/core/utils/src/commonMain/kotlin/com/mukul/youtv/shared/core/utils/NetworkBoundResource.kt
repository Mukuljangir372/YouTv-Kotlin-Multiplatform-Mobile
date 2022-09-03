package com.mukul.youtv.shared.core.utils

import com.mukul.youtv.shared.common.models.core.ApiResult
import com.mukul.youtv.shared.common.models.core.DataState
import com.mukul.youtv.shared.core.network.exception.NullResponseException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext

// infix - calling a extension function without dot operator.
// inline - for prevention of unnecessary memory allocation by
// not creating object of function everytime when passing block
// to lambda
// crossline - it prevents the use of return statement in lambda (marked with crossline)

suspend inline fun <ResultType, RequestType> networkBoundResource(
    dispatcher: CoroutineDispatcher,
    crossinline initialStart: suspend () -> Unit,
    crossinline query: suspend () -> ResultType,
    crossinline fetch: suspend () -> ApiResult<RequestType>?,
    crossinline shouldFetch: () -> Boolean = { true },
    crossinline saveFetchResult: (RequestType) -> ResultType,
    crossinline onFetchFailed: suspend (Exception) -> Unit,
): ResultType? {
    val shouldFetchValue = shouldFetch()
    var fetchSuccess = false
    val lock = Mutex()

    return withContext(dispatcher) {
        initialStart()
        val localData = try {
            query()
        }catch (e: Exception) {
            null
        }
        val fetchData = if(shouldFetchValue) {
            try {
                val data = fetch()?.data
                if(data != null) {
                    lock.tryLock()
                    fetchSuccess = true
                    lock.unlock()
                    saveFetchResult(data)
                }else {
                    null
                }
            }catch (e: Exception) {
                onFetchFailed(e)
                null
            }
        }else {
            null
        }
        if (fetchSuccess) fetchData ?: localData
        else localData ?: fetchData
    }
}

inline fun <ResultType, RequestType> networkBoundResourceAsFlow(
    dispatcher: CoroutineDispatcher,
    crossinline query: suspend () -> ResultType,
    crossinline fetch: suspend () -> ApiResult<RequestType>?,
    crossinline shouldFetch: () -> Boolean = { true },
    crossinline saveFetchResult: (RequestType) -> ResultType,
) = channelFlow<DataState<ResultType>> {
    var fetchException: Exception = NullResponseException()
    val result = networkBoundResource(
        dispatcher = dispatcher,
        initialStart = {
            send(DataState.Loading())
        },
        query = query,
        fetch = fetch,
        shouldFetch = shouldFetch,
        saveFetchResult = saveFetchResult,
        onFetchFailed = {
            fetchException = it
        }
    )
    val data = if(result == null) {
        DataState.Failure(fetchException.message)
    }else {
        DataState.Success<ResultType>(result)
    }
    send(data)
}












