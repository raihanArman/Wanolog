package com.ewalabs.kiiroi.presentation.dashboard.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ewalabs.kiiroi.composable.style.Colors
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.utils.AppNavigationContentPosition

/**
 * @author Raihan Arman
 * @date 02/02/23
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardPermanentNavigation(
    navController: NavHostController,
    navigationContentPosition: AppNavigationContentPosition,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    PermanentDrawerSheet(
        modifier = Modifier.sizeIn(
            minWidth = 200.dp,
            maxWidth = 300.dp
        ),
        drawerContainerColor = KiiroiAppTheme.colors.colorAccent,
        drawerTonalElevation = 5.dp,
        drawerShape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .layoutId(LayoutType.CONTENT)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            destinationList.forEach { item ->
                println("Item -> ${item.label}")
                NavigationDrawerItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route)
                    },
                    icon = {
                        item.icon()
                    },
                    label = {
                        Text(
                            text = item.label,
                            style = KiiroiAppTheme.typography.medium,
                            fontSize = 12.sp,
                            color = if (currentRoute == item.route) {
                                Color.White
                            } else {
                                Color.Gray.copy(alpha = 0.5f)
                            }
                        )
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = KiiroiAppTheme.colors.colorPrimary,
                        unselectedContainerColor = KiiroiAppTheme.colors.colorAccent,
                        unselectedTextColor = Color.Gray.copy(alpha = 0.5f),
                        unselectedIconColor = Color.Gray.copy(alpha = 0.5f),
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White
                    ),
                    shape = RoundedCornerShape(5.dp)
                )
            }
        }
//        Layout(
//            modifier = Modifier
//                .background(KiiroiAppTheme.colors.colorAccent)
//                .padding(16.dp),
//            content = {
//
//            },
//            measurePolicy = { measurables, constraints ->
//                lateinit var headerMeasurable: Measurable
//                lateinit var contentMeasurable: Measurable
//                measurables.forEach {
//                    when (it.layoutId) {
//                        LayoutType.HEADER -> headerMeasurable = it
//                        LayoutType.CONTENT -> contentMeasurable = it
//                        else -> error("Unknown layoutId encountered!")
//                    }
//                }
//
//                val headerPlaceable = headerMeasurable.measure(constraints)
//                val contentPlaceable = contentMeasurable.measure(
//                    constraints.offset(vertical = -headerPlaceable.height)
//                )
//                layout(constraints.maxWidth, constraints.maxHeight) {
//                    // Place the header, this goes at the top
//                    headerPlaceable.placeRelative(0, 0)
//
//                    // Determine how much space is not taken up by the content
//                    val nonContentVerticalSpace = constraints.maxHeight - contentPlaceable.height
//
//                    val contentPlaceableY = when (navigationContentPosition) {
//                        // Figure out the place we want to place the content, with respect to the
//                        // parent (ignoring the header for now)
//                        AppNavigationContentPosition.TOP -> 0
//                        AppNavigationContentPosition.CENTER -> nonContentVerticalSpace / 2
//                    }
//                        // And finally, make sure we don't overlap with the header.
//                        .coerceAtLeast(headerPlaceable.height)
//
//                    contentPlaceable.placeRelative(0, contentPlaceableY)
//                }
//            }
//        )
    }
}