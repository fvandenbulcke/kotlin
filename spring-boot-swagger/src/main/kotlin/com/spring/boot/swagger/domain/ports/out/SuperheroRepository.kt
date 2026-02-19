package com.spring.boot.swagger.domain.ports.out

import com.spring.boot.swagger.domain.models.Superhero
import java.util.UUID

interface SuperheroRepository {
    fun findAll(): List<Superhero>
    fun findById(id: UUID): Superhero?
}