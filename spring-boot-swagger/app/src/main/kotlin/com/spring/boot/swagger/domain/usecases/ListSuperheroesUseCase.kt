package com.spring.boot.swagger.domain.usecases

import com.spring.boot.swagger.domain.models.Superhero
import com.spring.boot.swagger.domain.ports.`in`.ListSuperheroesUseCasePort
import com.spring.boot.swagger.domain.ports.out.SuperheroRepository

class ListSuperheroesUseCase(
    private val repository: SuperheroRepository
): ListSuperheroesUseCasePort {
    override fun execute(): List<Superhero> = repository.findAll()
}
