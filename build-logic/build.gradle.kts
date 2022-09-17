plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}
dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.gradle.plugin)
    compileOnly(gradleApi())
}
gradlePlugin {
    plugins {
        fun createPlugin(id: String, className: String) {
            plugins.create(id) {
                this.id = id
                implementationClass = className
            }
        }
        createPlugin(
            id = "youtv_android_lib",
            className = "com.mukul.youtv.build.logic.YouTvAndroidAppLibPlugin"
        )
        createPlugin(
            id = "youtv_android_compose_lib",
            className = "com.mukul.youtv.build.logic.YouTvAndroidComposeAppLibPlugin"
        )
        createPlugin(
            id = "youtv_android_compose_hilt_lib",
            className = "com.mukul.youtv.build.logic.YouTvAndroidComposeHiltAppLibPlugin"
        )
        createPlugin(
            id = "youtv_kmm_lib",
            className = "com.mukul.youtv.build.logic.YouTvKmmLibPlugin"
        )
    }
}