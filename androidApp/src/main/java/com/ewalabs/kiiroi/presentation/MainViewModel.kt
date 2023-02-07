package com.ewalabs.kiiroi.presentation

import androidx.lifecycle.ViewModel
import com.ewalabs.kiiroi.utils.navigation.AppDisplay
import com.ewalabs.kiiroi.utils.navigation.AppWindowScreen
import com.ewalabs.navigation.AppNavigator

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class MainViewModel(
    private val appNavigator: AppNavigator,
    private val appWindowScreen: AppWindowScreen
): ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
    val windowScreen = appWindowScreen.appWindow

}