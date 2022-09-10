package com.mukul.youtv.graph

import com.mukul.youtv.di.getDatabaseModule
import com.mukul.youtv.di.koinModules
import com.mukul.youtv.shared.core.database.DriverFactory
import org.koin.core.context.startKoin

class BaseGraph {
    fun initKoin(
        driverFactory: DriverFactory,
    ) {
        startKoin {
            modules(getDatabaseModule(driverFactory))
            modules(koinModules())
        }
    }
}