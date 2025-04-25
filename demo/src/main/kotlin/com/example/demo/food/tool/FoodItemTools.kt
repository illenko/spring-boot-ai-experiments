package com.example.demo.food.tool

import com.example.demo.food.model.FoodItem
import com.example.demo.food.repository.FoodItemRepository
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Component

@Component
class FoodItemTools(
    private val foodItemRepository: FoodItemRepository,
) {
    @Tool(description = "All available food items or ingredients in the system for ordering with optional filters")
    fun getAllFoodItems(
        @ToolParam(required = false, description = "Name of food item or ingredient") name: String?,
        @ToolParam(required = false, description = "Category of food item or ingredient") category: String?,
        @ToolParam(required = false, description = "Min price of food item or ingredient") minPrice: Double?,
        @ToolParam(required = false, description = "Max price of food item or ingredient") maxPrice: Double?,
    ): List<FoodItem> =
        foodItemRepository.findAll(
            name = name,
            category = category,
            minPrice = minPrice,
            maxPrice = maxPrice,
        )
}
