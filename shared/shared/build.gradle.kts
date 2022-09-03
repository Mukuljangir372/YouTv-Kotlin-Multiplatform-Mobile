plugins {
    id("youtv_kmm_lib")
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin)
                implementation(libs.coroutines.core)

                api(project(":shared:common:models"))
                api(project(":shared:core:database"))
                api(project(":shared:core:utils"))
                implementation(project(":shared:tmdb"))
                implementation(project(":shared:core:network"))

                api(project(":shared:data:movie:models"))
                api(project(":shared:domain:movie:api"))
                implementation(project(":shared:data:movie:local:api"))
                implementation(project(":shared:data:movie:local:impl"))
                implementation(project(":shared:data:movie:network:api"))
                implementation(project(":shared:data:movie:network:impl"))
                implementation(project(":shared:domain:movie:impl"))
                implementation(project(":shared:domain:movie:test"))
            }
        }
        val commonTest by getting
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
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
