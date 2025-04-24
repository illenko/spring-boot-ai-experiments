package com.example.demo.api

import com.example.demo.service.ChatService
import com.example.demo.api.model.ChatRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ChatController(
    private val chatService: ChatService,
) {
    @PostMapping("/chat/{chatId}")
    fun chat(
        @PathVariable("chatId") chatId: String,
        @RequestBody request: ChatRequest,
    ): Flux<String> = chatService.chat(chatId, request)
}
