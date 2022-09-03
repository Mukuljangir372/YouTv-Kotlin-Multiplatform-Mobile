package com.mukul.youtv.shared.core.network.exception

class NullResponseException: Exception() {
    override val message: String
    get() = "Api call has null response"
}
