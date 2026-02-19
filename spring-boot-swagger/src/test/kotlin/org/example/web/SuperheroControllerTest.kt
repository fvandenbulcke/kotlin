package spring.boot.swagger.web

import org.mockito.kotlin.whenever
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import spring.boot.swagger.domain.usecases.GetSuperheroUseCase
import spring.boot.swagger.domain.usecases.ListSuperheroesUseCase
import spring.boot.swagger.domain.models.Superhero
import java.util.UUID
import org.springframework.http.MediaType
import spring.boot.swagger.application.api.SuperheroController

@WebMvcTest(controllers = [SuperheroController::class])
class SuperheroControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockBean
    lateinit var listUseCase: ListSuperheroesUseCase

    @MockBean
    lateinit var getUseCase: GetSuperheroUseCase

    @Test
    fun get_superheroes_returns_list() {
        val hero = Superhero(UUID.fromString("00000000-0000-0000-0000-000000000001"), "Captain Kotlin", setOf("X"))
        whenever(listUseCase.execute()).thenReturn(listOf(hero))

        mockMvc.perform(get("/superheroes"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$[0].name").value("Captain Kotlin"))
    }

    @Test
    fun get_superhero_by_id_returns_hero_when_found() {
        val id = UUID.fromString("00000000-0000-0000-0000-000000000001")
        val hero = Superhero(id, "Captain Kotlin", setOf("X"))
        whenever(getUseCase.execute(id)).thenReturn(hero)

        mockMvc.perform(get("/superheroes/$id"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Captain Kotlin"))
    }
}
