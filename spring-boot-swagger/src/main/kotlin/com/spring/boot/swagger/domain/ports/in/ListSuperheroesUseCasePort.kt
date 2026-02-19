package com.spring.boot.swagger.domain.ports.`in`

import com.spring.boot.swagger.domain.models.Superhero
import com.spring.boot.swagger.domain.ports.`in`.commands.NoInputCommand


interface ListSuperheroesUseCasePort: NoInputCommand<List<Superhero>> {
}