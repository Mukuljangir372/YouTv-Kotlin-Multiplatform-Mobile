package com.mukul.youtv.shared.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class Platform actual constructor() {
    actual val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
}