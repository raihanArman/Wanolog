package com.ewalabs.kiiroi.utils.navigation

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature
import com.ewalabs.kiiroi.utils.AppContentType
import com.ewalabs.kiiroi.utils.AppNavigationContentPosition
import com.ewalabs.kiiroi.utils.AppNavigationType
import com.ewalabs.kiiroi.utils.DevicePosture
import com.ewalabs.kiiroi.utils.isBookPosture
import com.ewalabs.kiiroi.utils.isSeparating
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Raihan Arman
 * @date 02/02/23
 */
class AppWindowScreenImpl: AppWindowScreen {
    override lateinit var appWindow: AppDisplay
    override lateinit var appDisplayType: AppDisplayType

    override fun setWindowScreen(
        windowSize: WindowSizeClass,
        displayFeatures: List<DisplayFeature>
    ) {
        appWindow = AppDisplay(
            windowSize = windowSize,
            displayFeatures = displayFeatures
        )

        setupDisplayType(appWindow)
    }

    private fun setupDisplayType(appWindow: AppDisplay?) {
        var navigationType: AppNavigationType ?= null
        var contentType: AppContentType ?= null
        var navigationContentPosition: AppNavigationContentPosition? = null
        appWindow?.apply {
            val foldingFeature = displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()

            val foldingDevicePosture = when {
                isBookPosture(foldingFeature) -> {
                    DevicePosture.BookPosture(foldingFeature.bounds)
                }
                isSeparating(foldingFeature) -> {
                    DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)
                }
                else -> DevicePosture.NormalPosture
            }

            when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    navigationType = AppNavigationType.BOTTOM_NAVIGATION
                    contentType = AppContentType.SINGLE_PANE
                }
                WindowWidthSizeClass.Medium -> {
                    navigationType = AppNavigationType.NAVIGATION_RAIL
                    contentType = if (foldingDevicePosture != DevicePosture.NormalPosture) {
                        AppContentType.DUAL_PANE
                    } else {
                        AppContentType.SINGLE_PANE
                    }
                }
                WindowWidthSizeClass.Expanded -> {
                    navigationType = if (foldingDevicePosture is DevicePosture.BookPosture) {
                        AppNavigationType.NAVIGATION_RAIL
                    } else {
                        AppNavigationType.PERMANENT_NAVIGATION_DRAWER
                    }
                    contentType = AppContentType.DUAL_PANE
                }
                else -> {
                    navigationType = AppNavigationType.BOTTOM_NAVIGATION
                    contentType = AppContentType.SINGLE_PANE
                }
            }

            navigationContentPosition = when (windowSize.heightSizeClass) {
                WindowHeightSizeClass.Compact -> {
                    AppNavigationContentPosition.TOP
                }
                WindowHeightSizeClass.Medium,
                WindowHeightSizeClass.Expanded -> {
                    AppNavigationContentPosition.CENTER
                }
                else -> {
                    AppNavigationContentPosition.TOP
                }
            }


        }
        appDisplayType = AppDisplayType(
            navigationType = navigationType!!,
            contentType = contentType!!,
            navigationContentPosition = navigationContentPosition!!
        )
    }

}