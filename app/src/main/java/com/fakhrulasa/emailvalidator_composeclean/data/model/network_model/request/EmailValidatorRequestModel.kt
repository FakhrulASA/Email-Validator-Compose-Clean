package com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.request

import kotlinx.serialization.Serializable

@Serializable
data class EmailValidatorRequestModel(
    val domain: String
)