plugins {
    id("youtv_kmm_lib")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "impl"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:base"))
                implementation(project(":shared:tmdb"))
                implementation(project(":shared:common:models"))
                implementation(project(":shared:core:utils"))
                implementation(project(":shared:data:movie:models"))
                implementation(project(":shared:data:movie:local:api"))
                implementation(project(":shared:data:movie:network:api"))
                implementation(project(":shared:domain:movie:api"))
                implementation(libs.koin)
                implementation(libs.coroutines.core)
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
