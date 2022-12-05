package com.randev.data.di

import com.randev.data.datasource.pref.AuthPreferences
import com.randev.data.datasource.pref.AuthPreferencesImpl
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 05/12/22
 */

val persistanceModule = module {
    single<AuthPreferences> { AuthPreferencesImpl(get()) }
}