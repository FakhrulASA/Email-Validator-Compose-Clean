package com.fakhrulasa.emailvalidator_composeclean.domain.repository

import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.request.EmailValidatorRequestModel
import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response.EmailValidatorResponseModel
import com.fakhrulasa.emailvalidator_composeclean.network.api.ApiInterface
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BaseRepository(
    private val baseUrl: String
) : ApiInterface, KoinComponent {
    private val httpClient: HttpClient by inject()
    override suspend fun validateEmail(emailValidatorRequestModel: EmailValidatorRequestModel): EmailValidatorResponseModel {
        // Making the GET request to validate email
        return httpClient.get("$baseUrl/validate-email") {
            contentType(io.ktor.http.ContentType.Application.Json)
            setBody(emailValidatorRequestModel)
            /**
             * If you want to send parameter
             */
//            parameter("email", email)

        }.body() // Automatically deserializes into EmailValidatorResponseModel
    }
}