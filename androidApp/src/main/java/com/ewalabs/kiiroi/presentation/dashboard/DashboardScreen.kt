package com.ewalabs.kiiroi.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.R
import com.ewalabs.kiiroi.presentation.comments.CommentsScreen
import com.ewalabs.kiiroi.presentation.dashboard.anime.AnimeScreen
import com.ewalabs.kiiroi.presentation.dashboard.manga.MangaScreen
import com.ewalabs.kiiroi.presentation.dashboard.post.PostAllScreen
import com.ewalabs.kiiroi.presentation.dashboard.profile.ProfileScreen
import com.ewalabs.kiiroi.presentation.dashboard.quote.QuoteAllScreen
import com.ewalabs.kiiroi.utils.Screen
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 22/11/22
 */

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = getViewModel()
) {
    val dashboardNav = rememberNavController()
    val iconSize = remember { 24.dp }

    Scaffold(
        bottomBar = {
            DashboardBottomBar(
                navController = dashboardNav,
                bottomBarItems = listOf(
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_home_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.POST,
                        label = "Home",
                        route = Screen.Post.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_ondemand_video_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.ANIME,
                        label = "Anime",
                        route = Screen.Anime.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.MANGA,
                        label = "Manga",
                        route = Screen.Manga.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.FAVORITE,
                        label = "Quote",
                        route = Screen.Quote.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_person_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.ACCOUNT,
                        label = "Account",
                        route = Screen.Account.route
                    ),
                )
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(KiiroiAppTheme.colors.colorPrimary)
                    .padding(bottom = it.calculateBottomPadding())
            ) {
                NavHost(
                    navController = dashboardNav,
                    startDestination = "dashboardBottomNav"
                ){
                    setupDashboardBottomNavScreens()
                }
            }
        }
    )

    CommentsScreen(
        sheetState = viewModel.sheetHandler,
        postId = viewModel.postId.value
    )

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