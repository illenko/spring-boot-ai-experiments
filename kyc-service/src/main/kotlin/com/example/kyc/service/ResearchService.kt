package com.example.kyc.service

import com.example.kyc.api.model.request.LegalEntityResearchRequest
import com.example.kyc.api.model.request.WebsiteResearchRequest
import com.example.kyc.api.model.response.LegalEntityResearchResponse
import com.example.kyc.api.model.response.WebsiteResearchResponse
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.stereotype.Service

@Service
class ResearchService(
    private val chatClient: ChatClient,
) {
    fun legalEntity(request: LegalEntityResearchRequest): LegalEntityResearchResponse? =
        chatClient
            .prompt(
                PromptTemplate(
                    """
                    Find information about legal entity with EDRPOU using https://youcontrol.com.ua/catalog/company_details/{edrpou}
                    """.trimIndent(),
                ).create(
                    mapOf(
                        "edrpou" to request.edrpou,
                    ),
                ),
            ).call()
            .entity(
                LegalEntityResearchResponse::class.java,
            )

    fun website(request: WebsiteResearchRequest): WebsiteResearchResponse? =
        chatClient
            .prompt(
                PromptTemplate(
                    """
                    Find information about website {url} by opening it.
                    """.trimIndent(),
                ).create(
                    mapOf(
                        "url" to request.url,
                    ),
                ),
            ).call()
            .entity(
                WebsiteResearchResponse::class.java,
            )
}
