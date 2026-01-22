package com.kotlin.ktor.koin.domain

import com.kotlin.ktor.koin.domain.model.Hero
import com.kotlin.ktor.koin.infrastructure.repository.InMemoryHeroRepository
import java.util.UUID

class HeroService(
    private val repository: InMemoryHeroRepository
) {

    fun getAllHeroes(): List<Hero> =
        repository.findAll()

    fun getHeroById(id: UUID): Hero? =
        repository.findById(id)

    fun createHero(name: String, powers: List<String>): Hero {
        val hero = Hero(
            id = UUID.randomUUID(),
            name = name,
            powers = powers
        )
        return repository.save(hero)
    }
}