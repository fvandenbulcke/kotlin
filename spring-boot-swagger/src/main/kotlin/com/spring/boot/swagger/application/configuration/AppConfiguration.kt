package com.spring.boot.swagger.application.configuration

import com.spring.boot.swagger.application.api.SuperheroController
import com.spring.boot.swagger.domain.ports.`in`.GetSuperheroUseCasePort
import com.spring.boot.swagger.domain.ports.`in`.ListSuperheroesUseCasePort
import com.spring.boot.swagger.domain.ports.out.SuperheroRepository
import com.spring.boot.swagger.domain.usecases.GetSuperheroUseCase
import com.spring.boot.swagger.domain.usecases.ListSuperheroesUseCase
import com.spring.boot.swagger.generated.api.HeroesApiDelegate
import com.spring.boot.swagger.infrastructure.ports.InMemorySuperheroRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {

    @Bean
    fun superheroRepository(): SuperheroRepository = InMemorySuperheroRepository()

    @Bean
    fun listSuperheroesUseCase(repository: SuperheroRepository): ListSuperheroesUseCasePort =
        ListSuperheroesUseCase(repository)

    @Bean
    fun getSuperheroUseCase(repository: SuperheroRepository): GetSuperheroUseCasePort = GetSuperheroUseCase(repository)

    @Bean
    fun heroesApiDelegate(listUseCase: ListSuperheroesUseCasePort, getUseCase: GetSuperheroUseCasePort): HeroesApiDelegate = SuperheroController(listUseCase, getUseCase)
}
