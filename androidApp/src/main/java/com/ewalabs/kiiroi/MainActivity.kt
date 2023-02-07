package com.ewalabs.kiiroi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.ewalabs.kiiroi.composable.components.notif.ConnectivityStatus
import com.ewalabs.kiiroi.presentation.MainScreen
import com.ewalabs.kiiroi.utils.navigation.AppWindowScreen
import com.google.accompanist.adaptive.calculateDisplayFeatures
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val windowScreen: AppWindowScreen by inject()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            windowScreen.setWindowScreen(
                windowSize = calculateWindowSizeClass(this),
                displayFeatures = calculateDisplayFeatures(this)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                ConnectivityStatus()
                MainScreen()
            }
        }
    }
}