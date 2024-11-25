package com.ponomarenko.skeleton.data.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkClientProvider {

    fun buildClient(): HttpClient =
        HttpClient(CIO) {
            installLogging()
            installTimeout()
            installSerializer()
            defaultRequest {
                url(BASE_URL)
                contentType(Json)
            }
        }

    private fun HttpClientConfig<out HttpClientEngineConfig>.installLogging() {
        install(Logging) {
            level = LogLevel.HEADERS
            filter { request ->
                request.url.host.contains("ktor.io")
            }
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }

    private fun HttpClientConfig<out HttpClientEngineConfig>.installTimeout() {
        install(HttpTimeout) {
            requestTimeoutMillis = 20_000
            connectTimeoutMillis = 20_000
            socketTimeoutMillis = 20_000
        }
    }

    private fun HttpClientConfig<out HttpClientEngineConfig>.installSerializer() {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    private companion object {

        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}