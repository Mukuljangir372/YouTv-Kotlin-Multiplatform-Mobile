package com.mukul.youtv.shared.core.network

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual class Platform actual constructor(){
    actual val ktorClientEngine: HttpClientEngineFactory<*> = Android
}