package com.mukul.youtv.shared.domain.movie.api

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}