package com.kotlin.ktor.koin.infrastructure.api.dto

import com.kotlin.ktor.koin.domain.model.Hero
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class HeroDto(
    @Serializable(with = UUIDAsStringSerializer::class)
    val id: UUID,
    val name: String,
    val powers: List<String>
) {
    companion object {
        fun from(hero: Hero): HeroDto =
            HeroDto(
                id = hero.id,
                name = hero.name,
                powers = hero.powers
            )
    }
}
