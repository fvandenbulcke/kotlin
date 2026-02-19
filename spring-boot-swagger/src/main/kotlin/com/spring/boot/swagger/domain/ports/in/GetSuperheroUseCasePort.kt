package com.spring.boot.swagger.domain.ports.`in`

import com.spring.boot.swagger.domain.models.Superhero
import com.spring.boot.swagger.domain.ports.`in`.commands.ApplicationCommand
import java.util.UUID

interface GetSuperheroUseCasePort: ApplicationCommand<UUID, Superhero> {
}