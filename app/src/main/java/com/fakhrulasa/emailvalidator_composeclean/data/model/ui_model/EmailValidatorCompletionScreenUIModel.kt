package com.fakhrulasa.emailvalidator_composeclean.data.model.ui_model

data class EmailValidatorCompletionScreenUIModel(
    val isEmailValid:Boolean,
    val blockStatus:Boolean,
    val disposableStatus: Boolean,
    val domain:String,
    val statusString:String,
    val whiteListStatus: String,
    val ip: String,
    val ipInfo: String
)