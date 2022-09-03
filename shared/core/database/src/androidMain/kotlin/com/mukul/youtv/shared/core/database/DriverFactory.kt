package com.mukul.youtv.shared.core.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(
    private val context: Context
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            YouTvAppDatabase.Schema,
            context = context,
            name = "YouTvSqlDatabase.db"
        )
    }
}