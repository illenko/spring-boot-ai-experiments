package com.example.demo.order.model

data class Order(
    val id: String,
    val userId: String,
    val items: List<FoodOrderItem>,
    val totalPrice: Double,
)

data class FoodOrderItem(
    val id: String,
    val name: String,
    val category: String,
    val price: Double,
)
