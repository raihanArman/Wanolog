package com.randev.kiiroi.android.presentation.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.randev.kiiroi.android.utils.Screen

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