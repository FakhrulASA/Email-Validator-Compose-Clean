package com.fakhrulasa.emailvalidator_composeclean.network.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


fun provideHttpClient(): HttpClient {
    val defaultHeader = mapOf(
        "Authorization" to "Bearer YOUR_TOKEN_HERE",
        "Custom-Header" to "HeaderValue"
    )
    return HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        defaultRequest {
            headers {
                defaultHeader.forEach { (key, value) ->
                    headers.append(key, value)
                }
            }

        }

}
}
