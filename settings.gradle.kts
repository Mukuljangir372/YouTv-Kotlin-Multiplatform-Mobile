pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "YouTv"
enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

includeBuild("build-logic") {
    dependencySubstitution {
        substitute(module("com.mukul.youtv:build-logic"))
            .using(project(":"))
    }
}
include(":android")
include(":android:app")
include(":android:core")
include(":android:features")
include(":shared")
include(":shared:shared")
include(":shared:core")
include(":shared:core:network")
include(":shared:core:database")
include(":shared:core:utils")
include(":shared:common")
include(":shared:common:models")
include(":shared:data")
include(":shared:domain")
include(":shared:data:movie")
include(":shared:domain:movie")
include(":shared:data:movie:models")
include(":shared:data:movie:local")
include(":shared:data:movie:network")
include(":shared:data:movie:local:api")
include(":shared:data:movie:local:impl")
include(":shared:data:movie:local:test")
include(":shared:data:movie:network:api")
include(":shared:data:movie:network:impl")
include(":shared:data:movie:network:test")
include(":shared:domain:movie:api")
include(":shared:domain:movie:impl")
include(":shared:domain:movie:test")
include(":shared:tmdb")
include(":android:features:ui-movie-list")
include(":android:common")
include(":shared:base")
include(":android:common:ui")
include(":android:base")
