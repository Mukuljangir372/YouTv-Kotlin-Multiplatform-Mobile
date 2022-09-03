package com.mukul.youtv.shared.core.database

class DatabaseFactory(
    private val driverFactory: DriverFactory
) {
    fun createDatabase(): YouTvAppDatabase {
        return YouTvAppDatabase(
            driver = driverFactory.createDriver()
        )
    }
}