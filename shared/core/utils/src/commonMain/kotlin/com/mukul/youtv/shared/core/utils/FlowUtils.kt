package com.mukul.youtv.shared.core.utils

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

interface Cancellable {
    fun cancel()
}

fun <T> Flow<T>.asCommonFlow(
    dispatcher: CoroutineDispatcher = Dispatchers.Main
): CommonFlow<T> = CommonFlow(
    origin = this,
    dispatcher = dispatcher
)

class CommonFlow<T>(
    private val origin: Flow<T>,
    private val dispatcher: CoroutineDispatcher,
) : Flow<T> by origin {
    fun watch(
        onEach: (T) -> Unit,
        onCompletion: (cause: Throwable?) -> Unit = { }
    ): Cancellable {
        val scope = CoroutineScope(SupervisorJob() + dispatcher)
        scope.launch {
            try {
                collect {
                    onEach(it)
                }
                onCompletion(null)
            } catch (e: Exception) {
                onCompletion(e)
            }
        }
        return object : Cancellable {
            override fun cancel() {
                scope.cancel()
            }
        }
    }
}