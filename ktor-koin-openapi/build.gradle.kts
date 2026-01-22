group = "com.kotlin.ktor.koin"
version = "1.0.0"
description = "super-hero-api"
java.sourceCompatibility = JavaVersion.VERSION_21

application {
    mainClass.set("com.kotlin.ktor.koin.ApplicationKt")
}

plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "2.3.0"
    kotlin("plugin.serialization") version "2.3.0"
    application
    id("io.ktor.plugin") version "3.4.0"
}

repositories {
    mavenLocal()
    mavenCentral()
}

ktor {
    openApi {
        enabled = true
        codeInferenceEnabled = true
        onlyCommented = false
    }
}

val ktorVersion = "3.4.0"

dependencies {
    api(libs.org.jetbrains.kotlin.kotlin.stdlib)
    api(libs.io.ktor.ktor.server.core)
    api(libs.io.ktor.ktor.server.netty.jvm)

    /* swagger */
    implementation("io.ktor:ktor-server-openapi-jvm:${ktorVersion}")
    implementation("io.ktor:ktor-server-swagger-jvm:${ktorVersion}")

    implementation("io.ktor:ktor-server-routing-openapi-jvm:${ktorVersion}")

    /* DI */
    api(libs.io.insert.koin.koin.core)
    api(libs.io.insert.koin.koin.ktor)

    /* serialisation */
    api(libs.io.ktor.ktor.server.content.negotiation.jvm)
    api(libs.io.ktor.ktor.serialization.kotlinx.json.jvm)

    /* logging */
    api(libs.ch.qos.logback.logback.classic)
    api(libs.io.github.oshai.kotlin.logging.jvm)

    testImplementation(libs.org.junit.jupiter.junit.jupiter)
    testImplementation(libs.org.jetbrains.kotlin.kotlin.test.junit5)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
