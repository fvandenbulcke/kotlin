package com.spring.boot.swagger.domain.ports.`in`.commands

interface ApplicationCommand<I,O> {
    fun execute(input: I): O;
}