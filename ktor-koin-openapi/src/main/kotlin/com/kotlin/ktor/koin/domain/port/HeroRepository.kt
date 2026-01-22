package com.kotlin.ktor.koin.domain.port

import com.kotlin.ktor.koin.domain.model.Hero
import java.util.UUID

interface HeroRepository{
    fun findAll(): List<Hero>
    fun findById(id: UUID): Hero?
    fun save(hero: Hero): Hero
}
