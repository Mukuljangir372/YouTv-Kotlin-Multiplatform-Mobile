plugins {
    kotlin("android")
    id("com.android.application")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()
    defaultConfig {
        applicationId = "com.mukul.youtv.android.app"
        minSdk = libs.versions.android.min.sdk.get().toInt()
        targetSdk = libs.versions.android.target.sdk.get().toInt()
        versionCode = libs.versions.android.version.code.get().toInt()
        versionName = libs.versions.android.version.name.get()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
dependencies {
    implementation(project(":shared:shared"))
    implementation(libs.android.material)
    implementation(libs.androidx.app.compat)
    implementation(libs.coroutines.android)
    implementation(libs.koin.android)
    implementation(libs.android.hilt)
    kapt(libs.android.hilt.compiler)
}
kapt {
    correctErrorTypes = true
}