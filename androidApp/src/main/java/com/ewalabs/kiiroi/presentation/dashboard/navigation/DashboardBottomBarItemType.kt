package com.ewalabs.kiiroi.presentation.dashboard

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme

enum class DashboardBottomBarItemType {
    ANIME, MANGA, FAVORITE, POST ,ACCOUNT
}

data class DashboardBottomBarItem(
    val icon: @Composable () -> Unit,
    val label: String,
    val type: DashboardBottomBarItemType,
    val route: String,
)