package com.randev.core

import android.app.Application
import com.randev.preferences.PreferencesFactory

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferencesFactory.appContext = this
    }
}
