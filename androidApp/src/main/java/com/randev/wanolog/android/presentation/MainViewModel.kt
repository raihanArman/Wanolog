package com.randev.wanolog.android.presentation

import androidx.lifecycle.ViewModel
import com.randev.navigation.AppNavigator

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class MainViewModel(
    private val appNavigator: AppNavigator
): ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
}