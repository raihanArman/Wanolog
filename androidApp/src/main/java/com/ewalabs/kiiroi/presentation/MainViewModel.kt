package com.ewalabs.kiiroi.presentation

import androidx.lifecycle.ViewModel
import com.ewalabs.navigation.AppNavigator

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class MainViewModel(
    private val appNavigator: AppNavigator
): ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
}