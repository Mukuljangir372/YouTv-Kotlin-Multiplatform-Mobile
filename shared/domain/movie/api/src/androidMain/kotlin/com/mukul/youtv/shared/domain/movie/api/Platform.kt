package com.mukul.youtv.shared.domain.movie.api

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}