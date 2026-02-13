package com.spring.boot.swagger.domain.errors

import java.util.UUID

class SuperheroNotFoundException(id: UUID) : RuntimeException("Superhero with id $id not found")
