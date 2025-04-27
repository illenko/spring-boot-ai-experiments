package com.example.kyc.api.model.response

data class LegalEntityResearchResponse(
    val edrpou: String?,
    val companyNameUk: String?,
    val registrationDate: String?,
    val legalAddress: String?,
    val director: String?,
    val mainActivityUk: String?,
    val statutoryCapital: String?,
    val currentStatusUk: String?,
    val foundersOwners: List<String> = emptyList(),
    val contactPhone: String?,
    val contactEmail: String?
)
