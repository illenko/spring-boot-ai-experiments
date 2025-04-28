package com.example.rag.service

import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Service

@Service
class PredictionService(
    private val chatClient: ChatClient,
)
