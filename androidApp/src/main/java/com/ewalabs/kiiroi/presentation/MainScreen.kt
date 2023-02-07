package com.ewalabs.kiiroi.presentation

import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ewalabs.navigation.Destination
import com.ewalabs.navigation.NavHostApp
import com.ewalabs.navigation.NavigationIntent
import com.ewalabs.navigation.composable
import com.ewalabs.kiiroi.presentation.anime_all.AnimeAllScreen
import com.ewalabs.kiiroi.presentation.anime_by_category.AnimeByCategoryScreen
import com.ewalabs.kiiroi.presentation.anime_detail.DetailAnimeScreen
import com.ewalabs.kiiroi.presentation.character_anime.CharacterAnimeScreen
import com.ewalabs.kiiroi.presentation.character_detail.CharacterDetailScreen
import com.ewalabs.kiiroi.presentation.character_manga.CharacterMangaScreen
import com.ewalabs.kiiroi.presentation.dashboard.DashboardScreen
import com.ewalabs.kiiroi.presentation.manga_all.MangaAllScreen
import com.ewalabs.kiiroi.presentation.manga_by_category.MangaByCategoryScreen
import com.ewalabs.kiiroi.presentation.manga_detail.MangaDetailScreen
import com.ewalabs.kiiroi.presentation.splash_screen.SplashScreen
import com.ewalabs.kiiroi.utils.AppContentType
import com.ewalabs.kiiroi.utils.AppNavigationContentPosition
import com.ewalabs.kiiroi.utils.AppNavigationType
import com.ewalabs.kiiroi.utils.DevicePosture
import com.ewalabs.kiiroi.utils.isBookPosture
import com.ewalabs.kiiroi.utils.isSeparating
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
    viewModel: MainViewModel = getViewModel(),
) {
    val navController = rememberAnimatedNavController()

    NavigationEffects(
        navigationChannel = viewModel.navigationChannel,
        navHostController = navController
    )

    NavHostApp(
        navController = navController,
        startDestination = Destination.SplashScreen
    ){
        composable(Destination.SplashScreen){
            SplashScreen()
        }
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
        composable(Destination.AnimeByCategoryScreen){
            AnimeByCategoryScreen()
        }
        composable(Destination.MangaByCategoryScreen){
            MangaByCategoryScreen()
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
                is NavigationIntent.NavigateAndReplace -> {
                    navHostController.apply {
                        popBackStack(graph.startDestinationId, true)
                        graph.setStartDestination(intent.route)
                        navigate(intent.route)
                    }
                }
            }
        }
    }
}
//
//@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
//@Preview(showBackground = true)
//@Composable
//fun ReplyAppPreview() {
//    KiiroiAppTheme {
//        MainScreen(
//            windowSize = WindowSizeClass.calculateFromSize(DpSize(400.dp, 900.dp)),
//            displayFeatures = emptyList(),
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
//@Preview(showBackground = true, widthDp = 700, heightDp = 500)
//@Composable
//fun ReplyAppPreviewTablet() {
//    KiiroiAppTheme {
//        MainScreen(
//            windowSize = WindowSizeClass.calculateFromSize(DpSize(700.dp, 500.dp)),
//            displayFeatures = emptyList(),
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
//@Preview(showBackground = true, widthDp = 500, heightDp = 700)
//@Composable
//fun ReplyAppPreviewTabletPortrait() {
//    KiiroiAppTheme {
//        MainScreen(
//            windowSize = WindowSizeClass.calculateFromSize(DpSize(500.dp, 700.dp)),
//            displayFeatures = emptyList(),
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
//@Preview(showBackground = true, widthDp = 1100, heightDp = 600)
//@Composable
//fun ReplyAppPreviewDesktop() {
//    KiiroiAppTheme {
//        MainScreen(
//            windowSize = WindowSizeClass.calculateFromSize(DpSize(1100.dp, 600.dp)),
//            displayFeatures = emptyList(),
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
//@Preview(showBackground = true, widthDp = 600, heightDp = 1100)
//@Composable
//fun ReplyAppPreviewDesktopPortrait() {
//    KiiroiAppTheme {
//        MainScreen(
//            windowSize = WindowSizeClass.calculateFromSize(DpSize(600.dp, 1100.dp)),
//            displayFeatures = emptyList(),
//        )
//    }
//}