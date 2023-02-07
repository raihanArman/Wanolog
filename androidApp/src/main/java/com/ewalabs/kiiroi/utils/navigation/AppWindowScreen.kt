package com.ewalabs.kiiroi.utils.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.window.layout.DisplayFeature
import com.ewalabs.navigation.NavigationIntent
import com.google.accompanist.adaptive.calculateDisplayFeatures
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Raihan Arman
 * @date 02/02/23
 */
interface AppWindowScreen {
    var appWindow: AppDisplay
    var appDisplayType: AppDisplayType

    fun setWindowScreen(
        windowSize: WindowSizeClass,
        displayFeatures: List<DisplayFeature>
    )

}