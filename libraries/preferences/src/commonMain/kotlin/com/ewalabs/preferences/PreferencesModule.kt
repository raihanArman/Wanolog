package com.ewalabs.preferences

import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 05/12/22
 */

val preferencesModule = module {
    single {
        PreferencesFactory.createPreferences()
    }
}
