package com.example.demo.order.tool

import com.example.demo.order.repository.OrderRepository
import org.springframework.stereotype.Component

@Component
class OrderTools(
    private val orderRepository: OrderRepository,
)
