package com.mukul.youtv.shared.core.network

import io.ktor.client.engine.*

expect class Platform constructor(){
    actual val ktorClientEngine: HttpClientEngineFactory<*>
}