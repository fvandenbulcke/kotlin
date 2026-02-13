package com.spring.boot.swagger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
    "com.spring.boot.swagger",
    "com.generated"
])
open class SpringBootSwaggerApplication

fun main(args: Array<String>) {
    runApplication<com.spring.boot.swagger.SpringBootSwaggerApplication>(*args)
}
