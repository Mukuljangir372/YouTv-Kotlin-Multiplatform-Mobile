import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension

@Suppress("UnstableApiUsage")
internal fun Project.version(key: String) = extensions
    .getByType(VersionCatalogsExtension::class.java)
    .named("libs")
    .findVersion(key)
    .get()
    .requiredVersion

//Versions
internal fun Project.versionInt(key: String) = version(key).toInt()
internal val Project.ANDROID_MIN_SDK_VERSION get() = versionInt("android_min_sdk")
internal val Project.ANDROID_TARGET_SDK_VERSION get() = versionInt("android_target_sdk")
internal val Project.ANDROID_COMPILE_SDK_VERSION get() = versionInt("android_compile_sdk")

internal val Project.YOUTV_KMM_VERSION get() = version("youtv_kmm")
internal val Project.SQLDELIGHT_VERSION get() = version("sqldelight")