package com.spring.boot.swagger.domain.usecases

import com.spring.boot.swagger.domain.errors.SuperheroNotFoundException
import com.spring.boot.swagger.domain.models.Superhero
import com.spring.boot.swagger.domain.ports.`in`.GetSuperheroUseCasePort
import com.spring.boot.swagger.domain.ports.out.SuperheroRepository
import java.util.UUID

class GetSuperheroUseCase (
    private val repository: SuperheroRepository
) : GetSuperheroUseCasePort {
    override fun execute(input: UUID): Superhero = repository.findById(input) ?: throw SuperheroNotFoundException(input)
}
