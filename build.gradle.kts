@Suppress(
    "DSL_SCOPE_VIOLATION",
    "MISSING_DEPENDENCY_CLASS",
    "UNRESOLVED_REFERENCE_WRONG_RECEIVER",
    "FUNCTION_CALL_EXPECTED",
    "UnstableApiUsage"
)
plugins {
    alias(libs.plugins.ben.manes.gradle)
}
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.gradle.plugin)
        classpath(libs.kotlin.serialization)
        classpath(libs.sqldelight.runtime)
        classpath(libs.ben.manes.gradle.plugin)
        classpath(libs.android.hilt.gradle.plugin)
        classpath("com.mukul.youtv:build-logic")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}