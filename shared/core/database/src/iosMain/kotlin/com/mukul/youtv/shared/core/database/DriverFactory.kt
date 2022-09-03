package com.mukul.youtv.shared.core.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            YouTvAppDatabase.Schema,
            name = "YouTvSqlDatabase.db"
        )
    }
}