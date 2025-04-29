package com.example.rag.api

import com.example.rag.model.MerchantConversion
import com.example.rag.model.PotentialMerchant
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.SearchRequest
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class DataLoadController(
    private val vectorStore: VectorStore,
    private val objectMapper: ObjectMapper,
) {
    @PostMapping("/api/v1/load-data")
    fun loadData(
        @RequestBody merchantConversions: List<MerchantConversion>,
    ): ResponseEntity<Boolean> {
        vectorStore.add(
            merchantConversions
                .map {
                    Document
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .text(objectMapper.writeValueAsString(it))
                        .build()
                },
        )

        return ResponseEntity.ok(true)
    }

    @PostMapping("/api/v1/find-similar")
    fun findSimilar(
        @RequestBody merchant: PotentialMerchant,
    ): ResponseEntity<List<Document>> {
        val searchRequest =
            SearchRequest
                .builder()
                .query(
                    """
                    Find similar merchant with category: ${merchant.merchantCategory}, 
                 
                    pciDSS compliance: ${merchant.pciDssCompliance},
                    mode: ${merchant.mode},
                    method: ${merchant.method}
                    """.trimMargin(),
                ).topK(3)
                .build()

        val similarDocuments = vectorStore.similaritySearch(searchRequest)

        return ResponseEntity.ok(
            similarDocuments,
        )
    }
}
