package com.example.kyc.config

import io.modelcontextprotocol.client.McpSyncClient
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfig {
    @Bean
    fun chatClient(
        @Autowired chatClientBuilder: ChatClient.Builder,
        mcpSyncClients: List<McpSyncClient>,
    ): ChatClient =
        chatClientBuilder
            .defaultSystem(
                """
                Поводь себе як чат для пошуку даних про юридичну особу.
                use brave search api to access opendatabot website.
                Не говори нічого про себе.
                Якщо ти не можеш щось знайти, відповідай "інформація не знайдена".
                """.trimIndent(),
            )
            .defaultAdvisors(SimpleLoggerAdvisor())
            .defaultTools(SyncMcpToolCallbackProvider(mcpSyncClients))
            .build()
}
