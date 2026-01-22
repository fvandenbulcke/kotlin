package com.kotlin.ktor.koin.infrastructure.repository

import com.kotlin.ktor.koin.domain.model.Hero
import com.kotlin.ktor.koin.domain.port.HeroRepository
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

class InMemoryHeroRepository : HeroRepository {
    private val heroes: ConcurrentHashMap<UUID, Hero> = ConcurrentHashMap<UUID, Hero>()

    constructor(){
        heroes[UUID.fromString("ce4b2b04-ce14-4824-99f5-beb6abb3dfbe")] = Hero(
            id = UUID.fromString("ce4b2b04-ce14-4824-99f5-beb6abb3dfbe"),
            name = "name",
            powers = listOf("power")
        )
    }

    override fun findAll(): List<Hero> =
        heroes.values.toList()

    override fun findById(id: UUID): Hero? =
        heroes[id]

    override fun save(hero: Hero): Hero {
        heroes[hero.id] = hero
        return hero
    }
}