# Super Heroes API - Spring Boot Swagger

## 📖 Présentation

Ce projet est une API REST développée pour découvrir **Kotlin** et **Spring Boot** au travers d’une approche **Contract-first** basée sur OpenAPI. La spécification OpenAPI sert de source de vérité et le code Kotlin est généré à partir de celle-ci.

L’application expose une API simple pour la gestion de super-héros, permettant notamment de :
- Lister tous les super-héros
- Récupérer les informations d’un héros par identifiant

---

## 🛠️ Technologies & Librairies

### Framework & Serveur
- **Spring Boot 4.0.2** - Framework applicatif pour services REST
  - `spring-boot-starter-web` - Serveur web MVC
  - `spring-boot-starter-validation` - Validation des entrées
  - `spring-boot-starter-actuator` - Endpoints d’observabilité

### Documentation API
- **Springdoc OpenAPI 3.0.1** - Génération et exposition de la documentation OpenAPI
  - `springdoc-openapi-starter-webmvc-ui` - Swagger UI

### Contract-first & Génération
- **OpenAPI Generator 7.19.0** - Génération de code Kotlin/Spring à partir de la spécification OpenAPI
  - `kotlin-spring` - Générateur Spring Boot Kotlin

### Sérialisation
- **Jackson Kotlin** - Sérialisation JSON
  - `jackson-module-kotlin`

### Build & Environnement
- **Kotlin 2.1.20** - Langage de programmation
- **Gradle** - Outil de build avec Kotlin DSL
- **Java 21** - Version de la JVM cible

### Tests
- **JUnit Jupiter 5.12.1** - Framework de tests
- **Spring Boot Test** - Support de tests Spring
- **Mockito Kotlin 4.1.0** - Mocking Kotlin
- **AssertJ 3.27.7** - Assertions fluides

---

## 🚀 Démarrage

```bash
# Build du projet (génération OpenAPI incluse)
./gradlew clean build

# Lancement de l'application
./gradlew bootRun
```

L’API sera accessible sur `http://localhost:8080`

Documentation Swagger (par défaut Springdoc) : `http://localhost:8080/swagger-ui/index.html`
