package com.mukul.youtv.shared.common.models

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}