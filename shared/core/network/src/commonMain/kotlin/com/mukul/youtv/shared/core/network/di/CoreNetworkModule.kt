package com.mukul.youtv.shared.core.network.di

import com.mukul.youtv.shared.core.network.KtorClientFactory
import com.mukul.youtv.shared.core.network.Platform
import io.ktor.client.*
import io.ktor.client.engine.*
import org.koin.dsl.module

val coreNetworkModule = module {
    single { provideKtorEngine() }
    single { provideKtorClientFactory(get()) }
    single { provideKtorHttpClient(get()) }
}
private fun provideKtorHttpClient(
    factory: KtorClientFactory
): HttpClient {
    return factory.build()
}
private fun provideKtorClientFactory(
    engine: HttpClientEngineFactory<*>
): KtorClientFactory {
    return KtorClientFactory(engine)
}
private fun provideKtorEngine(
): HttpClientEngineFactory<*> {
    return Platform().ktorClientEngine
}