package com.randev.database

import com.randev.wanolog.db.WanologDatabase
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 22/12/22
 */
fun setupForIos(): WanologDatabase {
    val driver = NativeSqliteDriver(WanologDatabase.Schema, "app.db")
    return WanologDatabase(driver)
}

actual fun databaseModule() = module {
    single {
        setupForIos()
    }
}