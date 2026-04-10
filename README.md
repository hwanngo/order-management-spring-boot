# FIS Order Management

Spring Boot order management application with form login, role-based authorization, and REST endpoints for orders, order lines, and dashboard reporting.

## Tech Stack

- Java 17
- Spring Boot 2.7
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL for local/runtime data
- H2 for automated tests

## Prerequisites

- Java 17
- Maven 3.6+
- MySQL if you want to run the app locally against a real database

## Getting Started

1. Copy `src/main/resources/application.properties.example` to `src/main/resources/application.properties`.
2. Set your database URL, username, password, and server port in `application.properties`.
3. Start the application:

```bash
mvn spring-boot:run
```

## Running Tests

Run the full test suite with:

```bash
mvn test
```

Tests use an in-memory H2 database through `src/test/resources/application.properties`, so they do not require a local MySQL instance.

## Security Notes

- Do not commit `src/main/resources/application.properties` or real credentials.
- Create application users and assign roles through your bootstrap or admin flow before first login.
- Keep temporary credentials out of project docs and rotate any short-lived access after setup.

## Project Layout

- `src/main/java/` — application code
- `src/main/resources/` — templates and runtime configuration
- `src/test/java/` — unit and security tests
- `src/test/resources/` — test-only configuration
