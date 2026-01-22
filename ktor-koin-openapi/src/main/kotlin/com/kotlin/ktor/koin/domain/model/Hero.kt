package com.kotlin.ktor.koin.domain.model

import java.util.*

data class Hero(
    val id: UUID,
    val name: String,
    val powers: List<String>
)
