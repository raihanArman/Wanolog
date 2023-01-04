package com.ewalabs.preferences

import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

/**
 * @author Raihan Arman
 * @date 05/12/22
 */

actual object PreferencesFactory {
    private val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )

    actual fun createPreferences(): Preferences =
        Preferences(createDataStore(documentDirectory?.path ?: ""))
}