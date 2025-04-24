package com.example.demo.service

import com.example.demo.api.model.ChatRequest
import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ChatService(
    private val chatClient: ChatClient,
) {
    fun chat(
        chatId: String,
        request: ChatRequest,
    ): Flux<String> =
        chatClient
            .prompt()
            .user(request.prompt)
            .stream()
            .content()
}
