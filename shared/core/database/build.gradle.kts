@Suppress(
    "DSL_SCOPE_VIOLATION",
    "MISSING_DEPENDENCY_CLASS",
    "UNRESOLVED_REFERENCE_WRONG_RECEIVER",
    "FUNCTION_CALL_EXPECTED",
    "UnstableApiUsage"
)
plugins {
    id("youtv_kmm_lib")
    alias(libs.plugins.sqldelight)
}
kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "database"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.sqldelight.runtime)
                implementation(libs.koin)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation(libs.sqldelight.android)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.sqldelight.native)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}
sqldelight {
    database("YouTvAppDatabase") {
        packageName = "com.mukul.youtv.shared.core.database"
        version = 2
    }
}