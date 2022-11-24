package com.randev.wanolog.android.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.R
import com.randev.wanolog.android.presentation.dashboard.characters.CharactersScreen
import com.randev.wanolog.android.presentation.dashboard.anime.AnimeScreen
import com.randev.wanolog.android.presentation.dashboard.manga.MangaScreen
import com.randev.wanolog.android.utils.Screen

/**
 * @author Raihan Arman
 * @date 22/11/22
 */

@Composable
fun DashboardScreen() {
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
                                painter = painterResource(id = R.drawable.ic_baseline_person_pin_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.CHARACTER,
                        label = "Chara",
                        route = Screen.Character.route
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
                        label = "Favorite",
                        route = Screen.Favorite.route
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
                    .background(MovieAppTheme.colors.colorPrimary)
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
}

@OptIn(ExperimentalMaterialApi::class)
fun NavGraphBuilder.setupDashboardBottomNavScreens(){
    navigation(
        startDestination = Screen.Anime.route,
        route = "dashboardBottomNav"
    ){
        composable(Screen.Anime.route){
            AnimeScreen()
        }
        composable(Screen.Manga.route){
            MangaScreen()
        }
        composable(Screen.Character.route){
            CharactersScreen()
        }
    }
}