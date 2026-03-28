plugins {
    java
    id("org.springframework.boot") version "4.0.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.diffplug.spotless") version "8.4.0"
    id("com.github.spotbugs") version "6.4.4"
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

spotbugs {
    ignoreFailures.set(false)
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("com.h2database:h2")
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
        targetExclude("node_modules/**")
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

val installGitHooks by tasks.registering(Exec::class) {
    description = "Installs git hooks from .githooks directory"
    group = "git hooks"
    workingDir = rootDir
    commandLine("git", "config", "core.hooksPath", ".githooks")
}

tasks.named("build") {
    dependsOn(installGitHooks)
}
