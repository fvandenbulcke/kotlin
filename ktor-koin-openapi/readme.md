# Super Hero API - Projet de découverte Kotlin

## 📖 Présentation

Ce projet est une API REST développée pour découvrir **Kotlin** et son écosystème riche. Il s'agit d'une application de gestion de super-héros qui permet de créer, consulter et gérer une collection de héros avec leurs super-pouvoirs.

L'application expose une API RESTful simple permettant de :
- Lister tous les super-héros
- Récupérer un héros spécifique par son identifiant
- Créer de nouveaux super-héros avec leurs pouvoirs

Le projet suit une architecture hexagonale (ports & adapters) avec une séparation claire entre la couche domaine, l'infrastructure et l'application, démontrant ainsi les bonnes pratiques de développement en Kotlin.

---

## 🛠️ Technologies & Librairies

### Framework & Serveur
- **Ktor 3.4.0** - Framework web asynchrone moderne pour Kotlin
  - `ktor-server-core` - Cœur du serveur
  - `ktor-server-netty` - Serveur Netty embarqué
  - `ktor-server-routing-openapi` - Support du routing avec OpenAPI

### Documentation API
- **Swagger/OpenAPI** - Documentation interactive de l'API
  - `ktor-server-openapi` - Génération de la spécification OpenAPI
  - `ktor-server-swagger` - Interface Swagger UI

### Sérialisation
- **Kotlinx Serialization** - Sérialisation JSON native pour Kotlin
  - `ktor-serialization-kotlinx-json` - Support JSON pour Ktor
  - `ktor-server-content-negotiation` - Négociation de contenu

### Injection de Dépendances
- **Koin 3.5.3** - Framework d'injection de dépendances léger pour Kotlin
  - `koin-core` - Cœur de Koin
  - `koin-ktor` - Intégration avec Ktor

### Logging
- **Logback 1.5.25** - Framework de logging
- **Kotlin Logging 7.0.14** - Façade de logging idiomatique pour Kotlin

### Build & Environnement
- **Kotlin 2.3.0** - Langage de programmation
- **Gradle** - Outil de build avec Kotlin DSL
- **Java 21** - Version de la JVM cible

### Tests
- **JUnit Jupiter 5.10.2** - Framework de tests unitaires
- **Kotlin Test** - Extensions Kotlin pour les tests

---

## 🚀 Démarrage

```bash
# Build du projet
./gradlew build

# Lancement de l'application
./gradlew run
```

L'API sera accessible sur `http://localhost:8080`

Documentation Swagger : `http://localhost:8080/swaggerUI`
