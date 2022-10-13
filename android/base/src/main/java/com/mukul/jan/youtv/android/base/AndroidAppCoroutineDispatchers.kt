package com.mukul.jan.youtv.android.base

import kotlinx.coroutines.CoroutineDispatcher

data class AndroidAppCoroutineDispatchers(
    val io: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher
)
