plugins {
    java
    id("org.springframework.boot") version "4.0.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.diffplug.spotless") version "8.4.0"
}

group = "bswe"
version = "0.0.1-SNAPSHOT"
description = "fh3"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    java {
        target("src/**/*.java")
        googleJavaFormat()
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
    }
    format("markdown") {
        target("*.md")
        trimTrailingWhitespace()
        endWithNewline()
    }
    format("json") {
        target("src/**/*.json")
        trimTrailingWhitespace()
        leadingTabsToSpaces()
        endWithNewline()
    }
    format("yaml") {
        target("**/*.yaml", "**/*.yml")
        trimTrailingWhitespace()
        leadingTabsToSpaces()
        endWithNewline()
    }
    format("misc") {
        target("*.gradle.kts", ".gitignore", ".gitattributes")
        trimTrailingWhitespace()
        leadingTabsToSpaces()
        endWithNewline()
    }
}
