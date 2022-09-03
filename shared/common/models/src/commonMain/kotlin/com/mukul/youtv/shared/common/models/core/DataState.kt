package com.mukul.youtv.shared.common.models.core

sealed class DataState<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T): DataState<T>(data = data)
    class Loading<T>(): DataState<T>()
    class Failure<T>(message: String? = null): DataState<T>(message = message)
}