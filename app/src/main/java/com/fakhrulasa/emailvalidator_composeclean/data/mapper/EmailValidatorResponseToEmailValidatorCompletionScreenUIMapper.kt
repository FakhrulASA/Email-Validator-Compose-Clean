package com.fakhrulasa.emailvalidator_composeclean.data.mapper

import com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response.EmailValidatorResponseModel
import com.fakhrulasa.emailvalidator_composeclean.data.model.ui_model.EmailValidatorCompletionScreenUIModel

object EmailValidatorResponseToEmailValidatorCompletionScreenUIMapper {
    fun EmailValidatorResponseModel.emailValidationResponseToEmailValidationCompletionScreenUi(): EmailValidatorCompletionScreenUIModel {
        return EmailValidatorCompletionScreenUIModel(
            isEmailValid = valid,
            blockStatus = block,
            disposableStatus = disposable,
            domain = domain?:"",
            statusString = text,
            whiteListStatus = reason?:"",
            ip = mx_ip?:"",
            ipInfo = mx_info?:""
        )
    }
}