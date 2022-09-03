package com.mukul.youtv.shared.core.utils

import kotlinx.coroutines.CoroutineDispatcher

actual class Platform actual constructor(){
    actual val defaultDispatcher: CoroutineDispatcher = IosDefaultCoroutineDispatcher()
}