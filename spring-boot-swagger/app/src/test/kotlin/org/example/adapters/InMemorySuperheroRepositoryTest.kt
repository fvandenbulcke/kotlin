package org.example.adapters

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import spring.boot.swagger.infrastructure.ports.InMemorySuperheroRepository

class InMemorySuperheroRepositoryTest {
    @Test
    fun `seeded heroes are available`() {
        val repo = InMemorySuperheroRepository()
        val all = repo.findAll()
        assertThat(all).isNotEmpty
    }
}
