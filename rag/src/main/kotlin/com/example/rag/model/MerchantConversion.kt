package com.example.rag.model

data class MerchantConversion(
    val merchantName: String,
    val merchantCategory: String,
    val gateway: String,
    val pciDssCompliance: Boolean,
    val mode: String,
    val method: String,
    val conversionRate: Double,
)
