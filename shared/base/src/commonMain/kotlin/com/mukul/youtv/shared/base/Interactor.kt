package com.mukul.youtv.shared.base

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.withTimeout

abstract class Interactor<Result,Params> {

    operator fun invoke(
        params: Params,
        withTimeout: Boolean = false,
        timeoutMs: Long = defaultTimeOut,
    ) = channelFlow {
        try {
            if(withTimeout) {
                withTimeout(timeoutMs) {
                    send(doWork(params))
                }
            }else {
                send(doWork(params))
            }
        }catch (e: TimeoutCancellationException) {
            send(null)
        }
    }.catch { _ ->
        emit(null)
    }

    suspend fun execute(params: Params): Result = doWork(params)

    abstract suspend fun doWork(params: Params): Result

    companion object {
        private const val defaultTimeOut = 5000L
    }
}