package com.mukul.youtv.shared.core.network

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}