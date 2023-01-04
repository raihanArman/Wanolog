package com.ewalabs.kiiroi.presentation.splash_screen

import androidx.lifecycle.ViewModel
import com.ewalabs.navigation.AppNavigator
import com.ewalabs.navigation.Destination

/**
 * @author Raihan Arman
 * @date 03/01/23
 */
class SplashViewModel(
    private val navigator: AppNavigator
): ViewModel() {

    fun goToDashboard() {
        navigator.tryNavigateAndReplaceStartRoute(Destination.DashboardScreen())
    }

}