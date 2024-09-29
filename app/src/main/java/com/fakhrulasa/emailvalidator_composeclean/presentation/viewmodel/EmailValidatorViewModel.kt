package com.fakhrulasa.emailvalidator_composeclean.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.request.EmailValidatorRequestModel
import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response.EmailValidatorResponseModel
import com.fakhrulasa.emailvalidator_composeclean.domain.interactor.ValidateEmailUseCase
import org.koin.core.component.KoinComponent

class EmailValidatorViewModel(
    private val validateEmailUseCase: ValidateEmailUseCase // Inject the use case
) : KoinComponent, ViewModel() {
    private val _emailValidatorResponse = MutableLiveData<EmailValidatorResponseModel?>()
    val emailValidatorResponse: LiveData<EmailValidatorResponseModel?> = _emailValidatorResponse

    private val _emailValidatorResponseError = MutableLiveData<String?>()
    val emailValidatorResponseError: LiveData<String?> = _emailValidatorResponseError
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    suspend fun validateEmail(email: String) {
        _loading.postValue(true)
        val requestModel = EmailValidatorRequestModel(email)
        val response = validateEmailUseCase.execute(requestModel)
        if (response.isSuccess) {
            _loading.postValue(false)
            _emailValidatorResponseError.postValue(null)
            _emailValidatorResponse.postValue(response.getOrNull())
        } else {
            _loading.postValue(false)
            _emailValidatorResponseError.postValue("Email validation is unsuccessful")
        }

    }
}