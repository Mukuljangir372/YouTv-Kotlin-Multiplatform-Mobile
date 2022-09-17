package com.mukul.youtv.build.logic

import ANDROID_COMPILE_SDK_VERSION
import ANDROID_COMPOSE_COMPILER_VERSION
import ANDROID_MIN_SDK_VERSION
import ANDROID_TARGET_SDK_VERSION
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

@Suppress("UnstableApiUsage")
class YouTvAndroidComposeHiltAppLibPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("com.android.library")
        target.plugins.apply("org.jetbrains.kotlin.android")
        target.plugins.apply("org.jetbrains.kotlin.kapt")
        target.plugins.apply("dagger.hilt.android.plugin")

        target.extensions.getByType(LibraryExtension::class.java).also {
            it.compileSdk = target.ANDROID_COMPILE_SDK_VERSION
            it.buildFeatures {
                compose = true
            }
            it.composeOptions {
                kotlinCompilerExtensionVersion = target.ANDROID_COMPOSE_COMPILER_VERSION
            }
            it.compileOptions {
                targetCompatibility = JavaVersion.VERSION_1_8
                sourceCompatibility = JavaVersion.VERSION_1_8
            }
            it.defaultConfig {
                minSdk = target.ANDROID_MIN_SDK_VERSION
                targetSdk = target.ANDROID_TARGET_SDK_VERSION
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }

        target.extensions.getByType(KaptExtension::class.java).also {
            it.correctErrorTypes = true
        }

        val libs = target.extensions.getByType<VersionCatalogsExtension>().named("libs")
        target.dependencies {
            add("implementation",libs.findLibrary("android.hilt").get())
            add("kapt",libs.findLibrary("android.hilt.compiler").get())
        }
    }
}