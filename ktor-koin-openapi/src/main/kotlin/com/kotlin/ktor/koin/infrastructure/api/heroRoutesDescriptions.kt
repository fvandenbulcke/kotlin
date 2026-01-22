package com.kotlin.ktor.koin.infrastructure.api

import com.kotlin.ktor.koin.infrastructure.api.dto.HeroDto
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.openapi.GenericElement
import io.ktor.openapi.Operation
import io.ktor.openapi.jsonSchema

fun Operation.Builder.describeGetAllHeroes() {
    summary = "Get heroes"
    description = "Retrieves a list of heroes."
    tag("Heroes")
    parameters {
        query("q") {
            description = "An encoded query"
            required = false
        }
    }
    responses {
        HttpStatusCode.OK {
            description = "A list of users"
            schema = jsonSchema<List<HeroDto>>()
        }
        HttpStatusCode.BadRequest {
            description = "Invalid query"
            ContentType.Text.Plain()
        }
    }
}

fun Operation.Builder.describeGetHeroById() {
    summary = "Get a single user by ID."
    description = "Retrieves a hero by its ID."
    tag("Heroes")
    parameters {
        path("id") {
            description = "the ID of the hero"
            required = true
            style = "simple"
            schema = jsonSchema<String>().copy(format = "uuid")
            example = GenericElement("e7a1f3f4-6d3c-4b1a-9b2c-123456789abc")
        }
    }
    responses {
        HttpStatusCode.OK {
            description = "The hero found with the given ID"
            schema = jsonSchema<HeroDto>()
        }
        HttpStatusCode.BadRequest {
            description = "The ID parameter is malformatted or missing"
            ContentType.Text.Plain()
        }
        HttpStatusCode.NotFound {
            description = "The hero for the given ID does not exist"
            ContentType.Text.Plain()
        }
    }
}

fun Operation.Builder.describeCreateHero() {
    summary = "Create a hero"
    description = "Create a hero."
    tag("Heroes")
    requestBody {
        description = "The hero to create"
        required = true
        content {
            schema = jsonSchema<CreateHeroRequest>()
        }
    }
    responses {
        HttpStatusCode.OK {
            description = "Created hero"
            schema = jsonSchema<HeroDto>()
        }
        HttpStatusCode.BadRequest {
            description = "Invalid body"
            ContentType.Text.Plain()
        }
    }
}