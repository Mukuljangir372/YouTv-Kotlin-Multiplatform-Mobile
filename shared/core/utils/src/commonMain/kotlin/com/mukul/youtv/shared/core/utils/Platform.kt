package com.mukul.youtv.shared.core.utils

import kotlinx.coroutines.CoroutineDispatcher

expect class Platform() {
    val defaultDispatcher: CoroutineDispatcher
}