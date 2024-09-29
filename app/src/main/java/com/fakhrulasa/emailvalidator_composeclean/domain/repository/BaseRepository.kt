package com.fakhrulasa.emailvalidator_composeclean.domain.repository

import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.request.EmailValidatorRequestModel
import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response.EmailValidatorResponseModel
import com.fakhrulasa.emailvalidator_composeclean.network.api.ApiInterface
import com.fakhrulasa.emailvalidator_composeclean.network.endpoints.EndPointConstants.ENDPOINT_DOMAIN
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.contentType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BaseRepository(
    private val baseUrl: String
) : ApiInterface, KoinComponent {
    private val httpClient: HttpClient by inject()
    override suspend fun validateEmail(emailValidatorRequestModel: EmailValidatorRequestModel): Result<EmailValidatorResponseModel> {

        return try {
            val response: EmailValidatorResponseModel = httpClient.get(baseUrl) {
                contentType(io.ktor.http.ContentType.Application.Json)
                /**
                 * If you want to send body with post request
                 */
//            setBody(emailValidatorRequestModel)
                /**
                 * If you want to send parameter
                 */
                parameter(ENDPOINT_DOMAIN, emailValidatorRequestModel.domain)

            }.body()

            if (response.valid) {
                // Email validation was successful
                Result.success(response)
            } else {
                // Email validation failed
                Result.failure(Exception(response.reason ?: "Unknown error"))
            }
        } catch (e: Exception) {
            // Handle any exceptions that occur during the network call
            Result.failure(e)
        }

    }
}