package com.ewalabs.kiiroi.utils.navigation

import com.ewalabs.kiiroi.utils.AppContentType
import com.ewalabs.kiiroi.utils.AppNavigationContentPosition
import com.ewalabs.kiiroi.utils.AppNavigationType

/**
 * @author Raihan Arman
 * @date 02/02/23
 */
data class AppDisplayType(
    val navigationType: AppNavigationType,
    val contentType: AppContentType,
    val navigationContentPosition: AppNavigationContentPosition
)
