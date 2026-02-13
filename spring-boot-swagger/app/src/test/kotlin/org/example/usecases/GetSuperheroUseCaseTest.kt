package org.example.usecases

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import spring.boot.swagger.domain.usecases.GetSuperheroUseCase
import spring.boot.swagger.domain.models.Superhero
import spring.boot.swagger.domain.errors.SuperheroNotFoundException
import spring.boot.swagger.domain.ports.out.SuperheroRepository
import java.util.UUID

class GetSuperheroUseCaseTest {

    private class StubRepo(private val heroes: List<Superhero>) : SuperheroRepository {
        override fun findAll(): List<Superhero> = heroes
        override fun findById(id: UUID): Superhero? = heroes.find { it.id == id }
    }

    @Test
    fun `execute returns hero when found`() {
        val id = UUID.randomUUID()
        val hero = Superhero(id, "Hero", setOf("strength"))
        val repo = StubRepo(listOf(hero))
        val useCase = GetSuperheroUseCase(repo)

        val result = useCase.execute(id)

        assertThat(result.id).isEqualTo(id)
        assertThat(result.name).isEqualTo("Hero")
    }

    @Test
    fun `execute throws when hero not found`() {
        val repo = StubRepo(emptyList())
        val useCase = GetSuperheroUseCase(repo)

        val unknown = UUID.randomUUID()

        assertThrows<SuperheroNotFoundException> {
            useCase.execute(unknown)
        }
    }
}
