package com.fakhrulasa.emailvalidator_composeclean.domain.interactor

import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response.EmailValidatorResponseModel

interface BaseUseCase<Request, Result> {
    suspend fun execute(request: Request): kotlin.Result<EmailValidatorResponseModel>
}