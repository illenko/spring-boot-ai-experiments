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
                Use brave search api to access Opendatabot and other websites.
                If you can't find something - set not found for this value.
                All answers should be in Ukrainian.
                """.trimIndent(),
            )
            .defaultAdvisors(SimpleLoggerAdvisor())
            .defaultTools(SyncMcpToolCallbackProvider(mcpSyncClients))
            .build()
}
