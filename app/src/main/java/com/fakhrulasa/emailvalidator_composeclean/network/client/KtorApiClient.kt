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
        "x-rapidapi-key" to "9b331297cfmsh8758e425c669262p177a17jsn246545f467d2",
        "x-rapidapi-hos" to "mailcheck.p.rapidapi.com"
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
