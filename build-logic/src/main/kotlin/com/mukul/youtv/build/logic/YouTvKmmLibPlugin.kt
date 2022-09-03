package com.mukul.youtv.build.logic

import ANDROID_COMPILE_SDK_VERSION
import ANDROID_MIN_SDK_VERSION
import ANDROID_TARGET_SDK_VERSION
import YOUTV_KMM_VERSION
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * plugins {
 *    kotlin("multiplatform") //is equal to id("org.jetbrains.kotlin.multiplatform")
 * }
 *
 * in the same way,
 * kotlin-DSL = 'org.gradle.kotlin.kotlin-dsl'
 */
@Suppress("UnstableApiUsage")
class YouTvKmmLibPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("com.android.library")
        target.plugins.apply("org.jetbrains.kotlin.multiplatform")
        target.plugins.apply("org.jetbrains.kotlin.native.cocoapods")
        target.version = target.YOUTV_KMM_VERSION

        target.extensions.getByType(KotlinMultiplatformExtension::class.java).also {
            it.android()
            it.iosX64()
            it.iosArm64()
            it.iosSimulatorArm64()
        }
        target.extensions.getByType(LibraryExtension::class.java).also {
            it.compileSdk = target.ANDROID_COMPILE_SDK_VERSION
            it.sourceSets.findByName("main")?.also { set ->
                set.manifest.srcFile("src/androidMain/AndroidManifest.xml")
            }
            it.compileOptions {
                targetCompatibility = JavaVersion.VERSION_1_8
                sourceCompatibility = JavaVersion.VERSION_1_8
            }
            it.defaultConfig {
                minSdk = target.ANDROID_MIN_SDK_VERSION
                targetSdk = target.ANDROID_TARGET_SDK_VERSION
            }
        }
    }
}