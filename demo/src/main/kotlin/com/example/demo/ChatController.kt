package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(
    private val chatService: ChatService,
) {

    @GetMapping("/chat")
    fun chat(
        @RequestParam prompt: String,
    ): String {
        return chatService.chat(prompt)
    }
}