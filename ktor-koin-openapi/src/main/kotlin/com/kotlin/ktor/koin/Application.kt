package com.kotlin.ktor.koin

import com.kotlin.ktor.koin.application.configureContext
import com.kotlin.ktor.koin.application.configureOpenApi
import com.kotlin.ktor.koin.application.configureSerialization
import com.kotlin.ktor.koin.infrastructure.api.configureApiRouting
import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

private val logger = KotlinLogging.logger {}

fun main() {
    logger.trace { "This is trace log" }
    logger.debug { "This is debug log" }
    logger.info { "This is info log" }
    logger.warn { "This is warn log" }
    logger.error { "This is error log" }
    
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

private fun Application.module() {
    configureSerialization()
    configureOpenApi()
    configureContext()
    configureApiRouting()
}