# fh3

A Spring Boot application built with Java 21, leveraging Spring Data JPA, Spring Web, and PostgreSQL. This project is configured with Gradle and includes Docker Compose support for easy local development.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Building the Project](#building-the-project)
  - [Running the Application](#running-the-application)
  - [Running Tests](#running-tests)
- [Database Configuration](#database-configuration)
- [Code Quality](#code-quality)
- [License](#license)

## Features

- **Spring Boot 4.0.4**: Utilizes a recent version of the Spring Boot framework.
- **Spring Data JPA**: For robust and efficient data access.
- **Spring Web (MVC)**: To build RESTful web services or serve web content.
- **Spring Boot DevTools**: Provides automatic restarts and live reload for faster development.
- **PostgreSQL**: Integrated database support with a Docker Compose configuration.
- **Docker Compose Support**: Automatically manages the database service for development.
- **Spotless**: Enforces consistent code formatting (Java, Markdown, JSON, YAML, etc.).
- **SpotBugs**: Static analysis to find bugs in Java code.
- **Git Hooks**: Pre-commit hooks for automated code quality checks.

## Prerequisites

To run this project locally, ensure you have the following installed:

- **Java 21**: The project uses the Java 21 toolchain.
- **Docker**: Required for running the PostgreSQL database service via Docker Compose.
- **Gradle**: The project includes the Gradle wrapper (`gradlew`), so no global Gradle installation is required.

## Getting Started

### Building the Project

To build the project and run all tests, execute:

```bash
./gradlew build
```

### Running the Application

You can start the application directly with:

```bash
./gradlew bootRun
```

When the application starts, it will automatically use the `compose.yaml` file to spin up a PostgreSQL container if Docker is running. By default, the application will be accessible at [http://localhost:8080](http://localhost:8080).

### Running Tests

To run the unit and integration tests:

```bash
./gradlew test
```

### Database Configuration

Local development settings are defined in `compose.yaml`:

- **Database**: `mydatabase`
- **User**: `myuser`
- **Password**: `secret`
- **Port**: `5432`
- **PostgreSQL Image**: `postgres:latest`

## Code Quality

This project uses [Spotless](https://github.com/diffplug/spotless) for automated code formatting and [SpotBugs](https://spotbugs.github.io/) for static analysis.

- **Check formatting**: `./gradlew spotlessCheck`
- **Apply formatting**: `./gradlew spotlessApply`
- **Run bug analysis**: `./gradlew spotbugsMain` (or `spotbugsTest`)

### Git Hooks

The project includes a pre-commit hook located in the `.githooks` directory. This hook ensures that `spotlessCheck` is run before every commit. These hooks are automatically installed when running the `./gradlew build` task.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
Copyright (c) 2026 Rajehdidntwakeup.
