package com.ewalabs.database

import com.ewalabs.wanolog.db.WanologDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 22/12/22
 */
actual fun databaseModule() = module {
    single {
        val driver = AndroidSqliteDriver(WanologDatabase.Schema, context = get(), "app.db")
        WanologDatabase(driver)
    }
}