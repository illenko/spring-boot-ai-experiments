package com.example.kyc.api.model.response

data class WebsiteResearchResponse(
    val hasShoppingCart: String?,
    val hasSecureCheckout: String?,
    val refundPolicy: String?,
    val contactInformation: String?,
    val shippingInformation: String?,
    val supportedPaymentMethodsDisplayed: List<String>?,
    val currencyDisplayed: String?,
    val languageDisplayed: String?,
    val itemCategories: List<String>?,
    val socialMediaLinks: List<String>?,
    val requiresAccountCreation: String?,
    val offersGuestCheckout: String?,
)
