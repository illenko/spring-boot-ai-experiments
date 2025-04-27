package com.example.kyc.api.model.response

data class WebsiteResearchResponse(
    val businessName: String?,
    val industry: String?,
    val productsServices: String?,
    val physicalAddress: String?,
    val contactEmail: String?,
    val contactPhone: String?,
    val shippingPolicy: String?,
    val returnPolicy: String?,
    val socialMediaLinks: List<String>? = emptyList(),
    val aboutUsSummary: String?,
    val paymentMethods: List<String>? = emptyList(),
)
