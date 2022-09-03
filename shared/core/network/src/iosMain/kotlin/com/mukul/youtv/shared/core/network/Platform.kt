package com.mukul.youtv.shared.core.network

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual class Platform actual constructor(){
    actual val ktorClientEngine: HttpClientEngineFactory<*> = Darwin
}
