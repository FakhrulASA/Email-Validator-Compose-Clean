package com.fakhrulasa.emailvalidator_composeclean.data.model.network_model.response

import kotlinx.serialization.Serializable

@Serializable
data class EmailValidatorResponseModel(
    val block: Boolean,
    val disposable: Boolean,
    val domain: String?,                 // Nullable
    val email_forwarder: Boolean,        // Not present in the failure case
    val last_changed_at: String?,        // Nullable
    val mx_info: String?,                // Nullable
    val mx_ip: String?,                  // Nullable
    val possible_typo: List<String> = emptyList(), // Default to empty list
    val reason: String?,                  // Nullable
    val risk: Int?,                       // Nullable
    val text: String,
    val valid: Boolean
)