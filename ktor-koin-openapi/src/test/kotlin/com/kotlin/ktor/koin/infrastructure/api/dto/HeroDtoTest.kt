package com.kotlin.ktor.koin.infrastructure.api.dto

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class HeroDtoTest {
    @Test
    fun `hero can be serialized to json`() {
        val hero = HeroDto(
            id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
            name = "Batman",
            powers = listOf("Intelligence", "Money")
        )

        val result = Json.encodeToString(HeroDto.serializer(), hero)
        val expected = """{"id":"123e4567-e89b-12d3-a456-426614174000","name":"Batman","powers":["Intelligence","Money"]}"""
        assertEquals(expected, result)
    }

    @Test
    fun `hero can be deserialized from json`() {
        val input = """
            {
              "id": "123e4567-e89b-12d3-a456-426614174000",
              "name": "Batman",
              "powers": ["Intelligence", "Money"]
            }
        """

        val hero = Json.decodeFromString(HeroDto.serializer(), input)
        val expected = HeroDto(
            id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
            name = "Batman",
            powers = listOf("Intelligence", "Money")
        )
        assertEquals(expected, hero)
    }
}
