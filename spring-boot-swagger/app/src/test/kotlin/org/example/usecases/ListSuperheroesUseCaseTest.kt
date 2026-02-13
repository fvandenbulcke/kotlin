package org.example.usecases

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import spring.boot.swagger.domain.usecases.ListSuperheroesUseCase
import spring.boot.swagger.domain.models.Superhero
import spring.boot.swagger.domain.ports.out.SuperheroRepository
import java.util.UUID

class ListSuperheroesUseCaseTest {

    private class StubRepo(private val heroes: List<Superhero>) : SuperheroRepository {
        override fun findAll(): List<Superhero> = heroes
        override fun findById(id: UUID): Superhero? = heroes.find { it.id == id }
    }

    @Test
    fun `execute returns all heroes from repository`() {
        val hero = Superhero(UUID.randomUUID(), "Hero", setOf("flying"))
        val repo = StubRepo(listOf(hero))
        val useCase = ListSuperheroesUseCase(repo)

        val result = useCase.execute()

        assertThat(result).hasSize(1)
        assertThat(result[0].name).isEqualTo("Hero")
    }
}
