package com.example.rag.model

data class PotentialMerchant(
    val merchantCategory: String,
    val pciDssCompliance: Boolean,
    val mode: String,
    val method: String,
)
