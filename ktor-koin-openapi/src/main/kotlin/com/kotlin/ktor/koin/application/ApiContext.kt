package com.kotlin.ktor.koin.application

import com.kotlin.ktor.koin.infrastructure.repository.InMemoryHeroRepository
import com.kotlin.ktor.koin.domain.HeroService
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

private val appModule = module {
    single { InMemoryHeroRepository() }
    single { HeroService(get()) }
}


fun Application.configureContext() {
    install(Koin) {
        modules(appModule)
    }
}