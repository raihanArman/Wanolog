package com.randev.kiiroi.android.presentation.splash_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.kiiroi.android.R
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.style.Colors
import kotlinx.coroutines.delay
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 03/01/23
 */

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = getViewModel()
) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        viewModel.goToDashboard()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.charlestonGreen),
        contentAlignment = Alignment.Center
    ) {
        BaseImageView(
            imageResourceId = R.drawable.logo,
            modifier = Modifier.size(100.dp)
        )
    }
}