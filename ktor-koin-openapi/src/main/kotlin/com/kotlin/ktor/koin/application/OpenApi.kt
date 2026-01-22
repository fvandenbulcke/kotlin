package com.kotlin.ktor.koin.application

import io.ktor.http.*
import io.ktor.openapi.*
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.routing.openapi.*
import io.ktor.utils.io.ExperimentalKtorApi

fun Application.configureOpenApi(){
    routing {

        @OptIn(ExperimentalKtorApi::class)
        get("/docs.json") {
            val doc = OpenApiDoc(info = OpenApiInfo("My API", "1.0")) + routingRoot.descendants()
            call.respond(doc)
        }.hide()

        swaggerUI("/swaggerUI") {
            info = OpenApiInfo("My API", "1.0")
            source = OpenApiDocSource.Routing(ContentType.Application.Json) {
                routingRoot.descendants()
            }
        }
    }
}
