package com.ewalabs.preferences

import android.content.Context

/**
 * @author Raihan Arman
 * @date 05/12/22
 */

actual object PreferencesFactory {
    lateinit var appContext: Context

    actual fun createPreferences(): Preferences =
        Preferences(
            createDataStore(appContext.filesDir.resolve(dataStoreFileName).absolutePath)
        )
}