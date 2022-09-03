package com.mukul.youtv.shared.core.database

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}