package com.example.demo.order.repository

import com.example.demo.order.model.FoodOrderItem
import com.example.demo.order.model.Order
import org.springframework.stereotype.Component

@Component
class OrderRepository {
    private val items =
        mapOf(
            "1" to
                Order(
                    id = "1",
                    userId = "1",
                    items =
                        listOf(
                            FoodOrderItem(
                                id = "1",
                                name = "Pizza",
                                category = "Food",
                                price = 10.0,
                            ),
                        ),
                    totalPrice = 10.0,
                ),
            "2" to
                Order(
                    id = "2",
                    userId = "1",
                    items =
                        listOf(
                            FoodOrderItem(
                                id = "2",
                                name = "Burger",
                                category = "Food",
                                price = 8.0,
                            ),
                        ),
                    totalPrice = 8.0,
                ),
            "3" to
                Order(
                    id = "3",
                    userId = "2",
                    items =
                        listOf(
                            FoodOrderItem(
                                id = "3",
                                name = "Salad",
                                category = "Food",
                                price = 5.0,
                            ),
                        ),
                    totalPrice = 5.0,
                ),
        )

    fun findAll(): List<Order> = items.values.toList()
}
