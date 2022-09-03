package com.mukul.youtv.shared.core.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class KtorClientFactory(
    private val clientEngine: HttpClientEngineFactory<*>
) {
    @OptIn(ExperimentalSerializationApi::class)
    fun build(): HttpClient {
        return HttpClient(clientEngine) {
            install(Logging) {
                logger = object: Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel.HEADERS
            }
            install(ContentNegotiation) {
                val jsonConfig = Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                }
                val contentTypes = listOf(Json)
                contentTypes.forEach {
                    register(it, KotlinxSerializationConverter(jsonConfig))
                }
            }
        }
    }
}