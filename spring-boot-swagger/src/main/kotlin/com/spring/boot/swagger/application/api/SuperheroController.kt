package com.spring.boot.swagger.application.api

import com.spring.boot.swagger.domain.errors.SuperheroNotFoundException
import com.spring.boot.swagger.domain.models.Superhero
import com.spring.boot.swagger.domain.ports.`in`.GetSuperheroUseCasePort
import com.spring.boot.swagger.domain.ports.`in`.ListSuperheroesUseCasePort
import com.spring.boot.swagger.generated.api.HeroesApiDelegate
import com.spring.boot.swagger.generated.model.Hero
import org.springframework.http.ResponseEntity
import java.util.*

class SuperheroController(
    private val listUseCase: ListSuperheroesUseCasePort,
    private val getUseCase: GetSuperheroUseCasePort
) : HeroesApiDelegate {

    fun Superhero.toDto() = Hero(id = this.id, name = this.name, powers = this.powers.toList())

    override fun getAllSuperHeroes(): ResponseEntity<List<Hero>> {
        return ResponseEntity.ok(listUseCase.execute().map { it.toDto() })
    }

    override fun getSuperHeroInformations(heroId: UUID): ResponseEntity<Hero> = try {
        val hero = getUseCase.execute(heroId)
        ResponseEntity.ok(hero.toDto())
    } catch (e: SuperheroNotFoundException) {
        ResponseEntity.notFound().build()
    }
}
