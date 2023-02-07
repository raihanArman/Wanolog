package com.ewalabs.kiiroi.utils.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.window.layout.DisplayFeature

/**
 * @author Raihan Arman
 * @date 02/02/23
 */
data class AppDisplay(
    val windowSize: WindowSizeClass,
    val displayFeatures: List<DisplayFeature>
)
