package com.randev.wanolog.android.presentation

import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.randev.navigation.Destination
import com.randev.navigation.NavHostApp
import com.randev.navigation.NavigationIntent
import com.randev.navigation.composable
import com.randev.wanolog.android.presentation.anime_all.AnimeAllScreen
import com.randev.wanolog.android.presentation.anime_detail.DetailAnimeScreen
import com.randev.wanolog.android.presentation.character_anime.CharacterAnimeScreen
import com.randev.wanolog.android.presentation.character_detail.CharacterDetailScreen
import com.randev.wanolog.android.presentation.character_manga.CharacterMangaScreen
import com.randev.wanolog.android.presentation.dashboard.DashboardScreen
import com.randev.wanolog.android.presentation.manga_all.MangaAllScreen
import com.randev.wanolog.android.presentation.manga_detail.MangaDetailScreen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = getViewModel()
) {
    val navController = rememberAnimatedNavController()

    NavigationEffects(
        navigationChannel = viewModel.navigationChannel,
        navHostController = navController
    )

    NavHostApp(
        navController = navController,
        startDestination = Destination.DashboardScreen
    ){
        composable(Destination.DashboardScreen){
            DashboardScreen()
        }
        composable(Destination.AnimeAllScreen){
            AnimeAllScreen()
        }
        composable(Destination.MangaAllScreen){
            MangaAllScreen()
        }
        composable(Destination.AnimeDetailScreen) {
            DetailAnimeScreen()
        }
        composable(Destination.MangaDetailScreen) {
            MangaDetailScreen()
        }
        composable(Destination.CharacterMangaScreen) {
            CharacterMangaScreen()
        }
        composable(Destination.CharacterAnimeScreen) {
            CharacterAnimeScreen()
        }
        composable(Destination.CharacterDetailScreen) {
            CharacterDetailScreen()
        }
    }

}


@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true){
                return@collect
            }
            when(intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route!!, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }
                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute){
                                inclusive = intent.inclusive
                            }
                        }
                    }
                }
            }
        }
    }
}