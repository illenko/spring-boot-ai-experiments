package com.example.kyc.config

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfig {
    @Bean
    fun chatClient(
        @Autowired chatClientBuilder: ChatClient.Builder,
    ): ChatClient =
        chatClientBuilder
            .defaultSystem(
                """
                All answers should be in Ukrainian.
                """.trimIndent(),
            ).defaultAdvisors(SimpleLoggerAdvisor())
            .build()
}
