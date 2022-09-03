package com.mukul.youtv.shared.common.models.core

sealed class ApiResult<T>(
    val data: T? = null,
    val message: String? = null,
    val exception: Exception? = null
) {
    class Success<T>(data: T): ApiResult<T>(data = data)
    class Loading<T> : ApiResult<T>()
    class FailureWith<T>(exception: Exception): ApiResult<T>(exception = exception)
    class Failure<T>(message: String?): ApiResult<T>(message = message)
}