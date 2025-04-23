package com.example.demo

import org.springframework.ai.chat.model.ChatModel
import org.springframework.stereotype.Service

@Service
class ChatService(
    private val chatModel: ChatModel,
) {
    fun chat(
        message: String,
    ): String = chatModel.call(message)

}