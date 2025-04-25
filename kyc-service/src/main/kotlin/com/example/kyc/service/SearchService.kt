package com.example.kyc.service

import com.example.kyc.api.model.SearchRequest
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class SearchService(
    private val chatClient: ChatClient,
) {
    fun search(request: SearchRequest): Flux<String> =
        chatClient
            .prompt(SEARCH.create(mapOf("edrpou" to request.edrpou)))
            .stream()
            .content()

    companion object {
        private val SEARCH =
            PromptTemplate(
                """
                Знайди дані за ЄДРПОУ {edrpou}.
                """.trimIndent(),
            )
    }
}
