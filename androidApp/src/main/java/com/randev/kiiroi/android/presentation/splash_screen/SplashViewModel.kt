package com.randev.kiiroi.android.presentation.splash_screen

import androidx.lifecycle.ViewModel
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination

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