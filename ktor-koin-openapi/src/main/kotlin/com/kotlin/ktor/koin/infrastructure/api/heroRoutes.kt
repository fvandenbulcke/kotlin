package com.kotlin.ktor.koin.infrastructure.api

import com.kotlin.ktor.koin.domain.HeroService
import com.kotlin.ktor.koin.infrastructure.api.dto.HeroDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.routing.openapi.*
import io.ktor.utils.io.*
import kotlinx.serialization.Serializable
import org.koin.ktor.ext.inject
import java.util.*

@Serializable
data class CreateHeroRequest(
    val name: String,
    val powers: List<String>
)

fun Application.configureApiRouting() {
    val heroService: HeroService by inject()
    routing {
        registerHeroRoutes(heroService,)
    }
}

@OptIn(ExperimentalKtorApi::class)
private fun Route.registerHeroRoutes(heroService: HeroService) {

    get("/heroes") {
        val response = heroService.getAllHeroes()
            .map { HeroDto.from(it) }
        call.respond(response)
    }.describe {
        describeGetAllHeroes()
    }

    get("/heroes/{id}") {
        val id = call.parameters["id"]?.let {
            runCatching { UUID.fromString(it) }.getOrNull()
        }

        if (id == null) {
            call.respond(HttpStatusCode.BadRequest, "Invalid UUID")
            return@get
        }

        val hero = heroService.getHeroById(id)

        if (hero == null) {
            call.respond(HttpStatusCode.NotFound, "Hero not found")
        } else {
            call.respond(HeroDto.from(hero))
        }
    }.describe {
        describeGetHeroById()
    }

    post("/heroes") {
        val request = call.receive<CreateHeroRequest>()

        val created = heroService.createHero(
            name = request.name,
            powers = request.powers
        )

        call.respond(HttpStatusCode.Created, HeroDto.from(created))
    }.describe {
        describeCreateHero()
    }
}
