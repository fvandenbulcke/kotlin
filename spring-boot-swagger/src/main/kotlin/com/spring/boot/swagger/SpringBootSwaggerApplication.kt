package com.spring.boot.swagger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
    "com.spring.boot.swagger",
    "com.spring.boot.swagger.generated"
])
open class SpringBootSwaggerApplication

fun main(args: Array<String>) {
    runApplication<SpringBootSwaggerApplication>(*args)
}
