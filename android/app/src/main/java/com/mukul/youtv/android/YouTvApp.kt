package com.mukul.youtv.android

import android.app.Application
import com.mukul.youtv.graph.BaseGraph
import com.mukul.youtv.shared.core.database.DriverFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class YouTvApp: Application() {
    override fun onCreate() {
        super.onCreate()
        BaseGraph().initKoin(DriverFactory(
            context = applicationContext
        ))
    }
}