package com.spring.boot.swagger.domain.models

import java.util.UUID

data class Superhero(
    val id: UUID,
    val name: String,
    val powers: Set<String>
)