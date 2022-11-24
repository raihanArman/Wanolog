package com.randev.wanolog.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.Greeting
import com.randev.wanolog.android.presentation.MainScreen
import com.randev.wanolog.android.presentation.anime_all.AnimeAllScreen
import com.randev.wanolog.android.presentation.dashboard.SetupNavGraph
import com.randev.wanolog.android.presentation.home.HomeScreen
import com.randev.wanolog.android.presentation.dashboard.manga.MangaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
//            MovieAppTheme {
//                val navHostController = rememberNavController()
//                SetupNavGraph(navController = navHostController)
////                AnimeAllScreen()
//            }
        }
    }
}