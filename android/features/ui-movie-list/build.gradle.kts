plugins {
    id("youtv_android_compose_hilt_lib")
}
dependencies {
    implementation(project(":shared:shared"))
    implementation(project("::android:common:ui"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.android.compose)
    debugImplementation(libs.bundles.android.compose.debug)
}