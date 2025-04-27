package com.example.kyc.api.model.response

data class LegalEntityResearchResponse(
    val edrpou: String,
    val companyNameUa: String,
    val registrationDate: String,
    val legalAddress: String,
    val director: String,
    val mainActivityDescriptionUa: String,
    val statutoryCapital: String,
)
