package com.mukul.youtv.shared.core.network.utils

import com.mukul.youtv.shared.common.models.core.ApiResult
import com.mukul.youtv.shared.core.network.exception.NullResponseException
import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend inline fun <reified T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    crossinline execute: suspend () -> HttpResponse?
): ApiResult<T> {
    return withContext(dispatcher) {
        try {
            val call = execute()
            if(isApiCallSuccess(call) && call?.body<T>() != null) {
                ApiResult.Success(call.body())
            }else {
                ApiResult.FailureWith(NullResponseException())
            }
        }catch (e: Exception) {
            ApiResult.FailureWith(e)
        }
    }
}

fun isApiCallSuccess(res: HttpResponse?): Boolean {
    return res?.status in setOf(
        HttpStatusCode.OK,
        HttpStatusCode.Created,
        HttpStatusCode.Accepted,
        HttpStatusCode.NonAuthoritativeInformation,
        HttpStatusCode.NoContent,
        HttpStatusCode.ResetContent,
    )
}
