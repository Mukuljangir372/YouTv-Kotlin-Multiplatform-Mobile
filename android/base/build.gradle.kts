plugins {
    id("youtv_android_lib")
}
android {
    namespace = "com.mukul.youtv.android.base"
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.android.coroutine)
}