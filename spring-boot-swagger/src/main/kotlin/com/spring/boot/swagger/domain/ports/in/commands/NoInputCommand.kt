package com.spring.boot.swagger.domain.ports.`in`.commands

interface NoInputCommand<O> {
    fun execute(): O;
}