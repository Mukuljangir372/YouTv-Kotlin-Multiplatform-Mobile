package com.mukul.youtv.shared.data.movie.models

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}