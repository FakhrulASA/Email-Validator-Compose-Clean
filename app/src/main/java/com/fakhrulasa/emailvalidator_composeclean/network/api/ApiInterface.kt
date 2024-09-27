package com.fakhrulasa.emailvalidator_composeclean.network.api

import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.request.EmailValidatorRequestModel
import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response.EmailValidatorResponseModel

interface ApiInterface {
    suspend fun validateEmail(emailValidatorRequestModel: EmailValidatorRequestModel): EmailValidatorResponseModel
}