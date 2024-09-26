package com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response

data class EmailValidatorResponseModel(
    val block: Boolean,
    val disposable: Boolean,
    val domain: String,
    val email_forwarder: Boolean,
    val last_changed_at: String,
    val mx_host: String,
    val mx_info: String,
    val mx_ip: String,
    val possible_typo: List<Any>,
    val reason: String,
    val risk: Int,
    val text: String,
    val valid: Boolean
)