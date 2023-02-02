package com.ewalabs.kiiroi.presentation.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.window.layout.DisplayFeature
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.R
import com.ewalabs.kiiroi.presentation.MainScreen
import com.ewalabs.kiiroi.presentation.comments.CommentsScreen
import com.ewalabs.kiiroi.presentation.dashboard.anime.AnimeScreen
import com.ewalabs.kiiroi.presentation.dashboard.manga.MangaScreen
import com.ewalabs.kiiroi.presentation.dashboard.navigation.DashboardBottomNavigation
import com.ewalabs.kiiroi.presentation.dashboard.navigation.DashboardPermanentNavigation
import com.ewalabs.kiiroi.presentation.dashboard.navigation.DashboardRailNavigation
import com.ewalabs.kiiroi.presentation.dashboard.post.PostAllScreen
import com.ewalabs.kiiroi.presentation.dashboard.profile.ProfileScreen
import com.ewalabs.kiiroi.presentation.dashboard.quote.QuoteAllScreen
import com.ewalabs.kiiroi.utils.AppContentType
import com.ewalabs.kiiroi.utils.AppNavigationContentPosition
import com.ewalabs.kiiroi.utils.AppNavigationType
import com.ewalabs.kiiroi.utils.Screen
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 22/11/22
 */

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = getViewModel(),
    navigationType: AppNavigationType,
    contentType: AppContentType,
    displayFeatures: List<DisplayFeature>,
    navigationContentPosition: AppNavigationContentPosition,
) {
    val dashboardNav = rememberNavController()

    if (navigationType == AppNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            DashboardPermanentNavigation(
                navController = dashboardNav,
                navigationContentPosition = navigationContentPosition
            )
            Box(
                modifier = Modifier
                    .background(KiiroiAppTheme.colors.colorPrimary)
            ) {
                DashboardContent(navController = dashboardNav)
            }
        }
    } else {
        Scaffold(
            bottomBar = {
                AnimatedVisibility(visible = navigationType == AppNavigationType.BOTTOM_NAVIGATION) {
                    DashboardBottomNavigation(navController = dashboardNav)
                }
            },
            content = {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    AnimatedVisibility(visible = navigationType == AppNavigationType.NAVIGATION_RAIL) {
                        DashboardRailNavigation(
                            navController = dashboardNav,
                            navigationContentPosition = navigationContentPosition
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(KiiroiAppTheme.colors.colorPrimary)
                            .padding(bottom = it.calculateBottomPadding())
                    ) {
                        DashboardContent(navController = dashboardNav)
                    }
                }
            }
        )
    }

    CommentsScreen(
        sheetState = viewModel.sheetHandler,
        postId = viewModel.postId.value
    )
}

@Composable
fun DashboardContent(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "dashboardBottomNav"
    ){
        setupDashboardBottomNavScreens()
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun NavGraphBuilder.setupDashboardBottomNavScreens(){
    navigation(
        startDestination = Screen.Post.route,
        route = "dashboardBottomNav"
    ){
        composable(Screen.Anime.route){
            AnimeScreen()
        }
        composable(Screen.Manga.route){
            MangaScreen()
        }
        composable(Screen.Post.route){
            PostAllScreen()
        }
        composable(Screen.Quote.route){
            QuoteAllScreen()
        }
        composable(Screen.Account.route){
            ProfileScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun ReplyAppPreview() {
    KiiroiAppTheme {
        MainScreen(
            windowSize = WindowSizeClass.calculateFromSize(DpSize(400.dp, 900.dp)),
            displayFeatures = emptyList(),
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun ReplyAppPreviewTablet() {
    KiiroiAppTheme {
        MainScreen(
            windowSize = WindowSizeClass.calculateFromSize(DpSize(700.dp, 500.dp)),
            displayFeatures = emptyList(),
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, widthDp = 500, heightDp = 700)
@Composable
fun ReplyAppPreviewTabletPortrait() {
    KiiroiAppTheme {
        MainScreen(
            windowSize = WindowSizeClass.calculateFromSize(DpSize(500.dp, 700.dp)),
            displayFeatures = emptyList(),
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, widthDp = 1100, heightDp = 600)
@Composable
fun ReplyAppPreviewDesktop() {
    KiiroiAppTheme {
        MainScreen(
            windowSize = WindowSizeClass.calculateFromSize(DpSize(1100.dp, 600.dp)),
            displayFeatures = emptyList(),
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, widthDp = 600, heightDp = 1100)
@Composable
fun ReplyAppPreviewDesktopPortrait() {
    KiiroiAppTheme {
        MainScreen(
            windowSize = WindowSizeClass.calculateFromSize(DpSize(600.dp, 1100.dp)),
            displayFeatures = emptyList(),
        )
    }
}