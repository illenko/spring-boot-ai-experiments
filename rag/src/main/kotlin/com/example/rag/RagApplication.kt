package com.example.rag

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KycApplication

fun main(args: Array<String>) {
	runApplication<KycApplication>(*args)
}
