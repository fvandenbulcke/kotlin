package com.spring.boot.swagger.infrastructure.ports

import com.spring.boot.swagger.domain.models.Superhero
import com.spring.boot.swagger.domain.ports.out.SuperheroRepository
import java.util.UUID

class InMemorySuperheroRepository : SuperheroRepository {

    // In-memory storage stored in attributes (seeded)
    private val heroes: Map<UUID, Superhero>

    init {
        val hero1 = Superhero(UUID.fromString("00000000-0000-0000-0000-000000000001"), "Captain Kotlin", setOf("Super typing", "Null-safety punch"))
        val hero2 = Superhero(UUID.fromString("00000000-0000-0000-0000-000000000002"), "The JVM Whisperer", setOf("Bytecode control", "GC whisper"))
        heroes = listOf(hero1, hero2).associateBy { it.id }
    }

    override fun findAll(): List<Superhero> = heroes.values.toList()

    override fun findById(id: UUID): Superhero? = heroes[id]
}
