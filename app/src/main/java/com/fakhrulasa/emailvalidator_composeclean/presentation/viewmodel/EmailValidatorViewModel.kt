package com.fakhrulasa.emailvalidator_composeclean.presentation.viewmodel

import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.request.EmailValidatorRequestModel
import com.fakhrulasa.emailvalidator_composeclean.domain.interactor.ValidateEmailUseCase
import org.koin.core.component.KoinComponent

class EmailValidatorViewModel(
    private val validateEmailUseCase: ValidateEmailUseCase // Inject the use case
) : KoinComponent {

    suspend fun validateEmail(email: String) {
        val requestModel = EmailValidatorRequestModel(email)
        val response = validateEmailUseCase.execute(requestModel)
    }
}