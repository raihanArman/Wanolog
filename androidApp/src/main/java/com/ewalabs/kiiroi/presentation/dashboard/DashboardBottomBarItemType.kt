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
    val route: String
)

@Composable
fun DashboardBottomBar(
    bottomBarItems: List<DashboardBottomBarItem>,
    navController: NavHostController
) {

    val surfaceColor = KiiroiAppTheme.colors.colorAccent
    val contentColor = Color.White

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        backgroundColor = surfaceColor,
        contentColor = contentColor,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        bottomBarItems.forEach { item ->
            if(!DashboardBottomBarItemType.values().contains(item.type)){
                throw Exception("Unknown item type! Please add this type inside the DashboardBottomBarItemType enum class.")
            }

            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    item.icon()
                },
                alwaysShowLabel = true,
                selectedContentColor = KiiroiAppTheme.colors.colorPrimary,
                unselectedContentColor = Color.Gray.copy(alpha = 0.5f),
                label = {
                    Text(
                        text = item.label,
                        style = KiiroiAppTheme.typography.medium,
                        fontSize = 12.sp,
                        color = if (currentRoute == item.route) {
                            KiiroiAppTheme.colors.colorPrimary
                        } else {
                            Color.Gray.copy(alpha = 0.5f)
                        }
                    )
                }
            )
        }
    }
}