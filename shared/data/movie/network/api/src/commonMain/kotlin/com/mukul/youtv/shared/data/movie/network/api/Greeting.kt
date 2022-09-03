package com.mukul.youtv.shared.data.movie.network.api

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}