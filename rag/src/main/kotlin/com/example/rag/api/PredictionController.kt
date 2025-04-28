package com.example.rag.api

import com.example.rag.service.PredictionService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/predict")
class PredictionController(
    private val service: PredictionService,
)
