package com.fakhrulasa.emailvalidator_composeclean.domain.interactor

import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.request.EmailValidatorRequestModel
import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response.EmailValidatorResponseModel
import com.fakhrulasa.emailvalidator_composeclean.domain.repository.BaseRepository

class ValidateEmailUseCase(
    private val baseRepository: BaseRepository // Inject your repository here
) : BaseUseCase<EmailValidatorRequestModel, EmailValidatorResponseModel> {

    override suspend fun execute(request: EmailValidatorRequestModel): Result<EmailValidatorResponseModel> {
        return baseRepository.validateEmail(request)
    }
}