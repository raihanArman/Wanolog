package com.ewalabs.kiiroi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.ewalabs.kiiroi.composable.components.notif.ConnectivityStatus
import com.ewalabs.kiiroi.presentation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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