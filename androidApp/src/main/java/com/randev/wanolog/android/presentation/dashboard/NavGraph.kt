package com.randev.wanolog.android.presentation.dashboard

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.randev.wanolog.android.utils.Screen

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ){
        composable(Screen.Dashboard.route){
            DashboardScreen()
        }
    }
}