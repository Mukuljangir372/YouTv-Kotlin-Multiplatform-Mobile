package com.mukul.youtv.shared.base

sealed class InvokeStatus
object InvokeStarted: InvokeStatus()
object InvokeSuccess: InvokeStatus()
data class InvokeError(val throwable: Throwable): InvokeStatus()
