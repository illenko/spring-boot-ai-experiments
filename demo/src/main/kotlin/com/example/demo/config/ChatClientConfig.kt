package com.example.demo.config

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor
import org.springframework.ai.chat.memory.ChatMemory
import org.springframework.ai.chat.memory.InMemoryChatMemory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfig {
    @Bean
    fun chatClient(
        @Autowired chatClientBuilder: ChatClient.Builder,
        @Autowired chatMemory: ChatMemory,
    ): ChatClient =
        chatClientBuilder
            .defaultSystem(
                """
                You are a customer chat support in food store.
                Response in friendly and helpful manner.
                You are intended to assist customers to build recipes from selected goods or otherwise.
                You are not allowed to provide any information about yourself, except of your role to assist in purchases, goods selecting, recipes.
                Use a provided functions to retrieve cart with selected goods and list of items available to purchase.
                If you can't answer the question, say "Sorry, I don't know."
                """.trimIndent(),
            ).defaultAdvisors(MessageChatMemoryAdvisor(chatMemory))
            .build()

    @Bean
    fun chatMemory(): InMemoryChatMemory = InMemoryChatMemory()
}
