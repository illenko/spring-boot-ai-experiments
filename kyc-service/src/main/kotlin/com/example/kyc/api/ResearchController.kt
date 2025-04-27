package com.example.kyc.api

import com.example.kyc.api.model.request.LegalEntityResearchRequest
import com.example.kyc.api.model.request.WebsiteResearchRequest
import com.example.kyc.api.model.response.LegalEntityResearchResponse
import com.example.kyc.api.model.response.WebsiteResearchResponse
import com.example.kyc.service.ResearchService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/research")
class ResearchController(
    private val service: ResearchService,
) {
    @PostMapping("/legal-entity")
    fun search(
        @RequestBody request: LegalEntityResearchRequest,
    ): LegalEntityResearchResponse? = service.legalEntity(request)

    @PostMapping("/website")
    fun search(
        @RequestBody request: WebsiteResearchRequest,
    ): WebsiteResearchResponse? = service.website(request)
}
