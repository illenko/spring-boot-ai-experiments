package com.example.kyc.api

import com.example.kyc.api.model.SearchRequest
import com.example.kyc.service.SearchService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ChatController(
    private val searchService: SearchService,
) {
    @PostMapping("/search")
    fun search(
        @RequestBody request: SearchRequest,
    ): String? = searchService.search(request = request)
}
