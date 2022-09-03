package com.mukul.youtv.shared.data.movie.local.test

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}