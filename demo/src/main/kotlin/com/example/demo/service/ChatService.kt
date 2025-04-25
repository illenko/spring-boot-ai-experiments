package com.example.demo.service

import com.example.demo.api.model.ChatRequest
import com.example.demo.food.tool.FoodItemTools
import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ChatService(
    private val chatClient: ChatClient,
    private val foodItemTools: FoodItemTools,
) {
    fun chat(
        chatId: String,
        request: ChatRequest,
    ): Flux<String> =
        chatClient
            .prompt()
            .user(request.prompt)
            .tools(foodItemTools)
            .stream()
            .content()
}
