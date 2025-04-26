package com.example.kyc.service

import com.example.kyc.api.model.SearchRequest
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val chatClient: ChatClient,
) {
    fun search(request: SearchRequest): String? =
        chatClient
            .prompt(SEARCH.create(mapOf("edrpou" to request.edrpou)))
            .call()
            .content()

    companion object {
        private val SEARCH =
            PromptTemplate(
                """
                Opendatabot дані за ЄДРПОУ {edrpou}
                """.trimIndent(),
            )
    }
}
