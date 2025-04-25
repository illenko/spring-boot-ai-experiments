package com.example.demo.food.repository

import com.example.demo.food.model.FoodItem
import org.springframework.stereotype.Repository

@Repository
class FoodItemRepository {
    private val items =
        mapOf(
            "1" to FoodItem(id = "1", name = "Potato", category = "vegetables", price = 12.99, stock = 10),
            "2" to FoodItem(id = "2", name = "Tomato", category = "vegetables", price = 8.99, stock = 20),
            "3" to FoodItem(id = "3", name = "Onion", category = "vegetables", price = 5.99, stock = 15),
            "4" to FoodItem(id = "4", name = "Chicken", category = "meat", price = 15.99, stock = 5),
            "5" to FoodItem(id = "5", name = "Beef", category = "meat", price = 20.99, stock = 8),
            "6" to FoodItem(id = "6", name = "Fish", category = "seafood", price = 25.99, stock = 12),
            "7" to FoodItem(id = "7", name = "Rice", category = "grains", price = 2.99, stock = 50),
            "8" to FoodItem(id = "8", name = "Pasta", category = "grains", price = 3.99, stock = 30),
            "9" to FoodItem(id = "9", name = "Bread", category = "bakery", price = 1.99, stock = 100),
            "10" to FoodItem(id = "10", name = "Cake", category = "bakery", price = 15.99, stock = 20),
        )

    fun findAll(
        name: String? = null,
        category: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null,
    ): List<FoodItem> {
        if (name == null && category == null && minPrice == null && maxPrice == null) {
            return items.values.toList()
        }
        return items.values.filter { foodItem ->
            (name == null || foodItem.name.contains(name, ignoreCase = true)) &&
                (category == null || foodItem.category.equals(category, ignoreCase = true)) &&
                (minPrice == null || foodItem.price >= minPrice) &&
                (maxPrice == null || foodItem.price <= maxPrice)
        }
    }
}
