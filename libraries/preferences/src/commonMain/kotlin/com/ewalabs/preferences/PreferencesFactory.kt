package com.ewalabs.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory.createWithPath
import okio.Path.Companion.toPath
import androidx.datastore.preferences.core.Preferences as DataStorePreferences

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
internal const val dataStoreFileName = "wanalog.preferences_pb"

fun createDataStore(path: String): DataStore<DataStorePreferences> = createWithPath(
    produceFile = { path.toPath() }
)

expect object PreferencesFactory {
    fun createPreferences(): Preferences
}