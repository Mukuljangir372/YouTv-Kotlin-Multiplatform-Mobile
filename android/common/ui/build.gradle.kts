plugins {
    id("youtv_android_compose_hilt_lib")
}
android {
    namespace = "com.mukul.youtv.android.common.ui"
}
dependencies {
    implementation(project(":shared:shared"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.android.compose)
    debugImplementation(libs.bundles.android.compose.debug)
    implementation(libs.android.compose.coil)
}