package com.ewalabs.movieapp_kmm.android.composable.components.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme

/**
 * @author Raihan Arman
 * @date 12/10/22
 */

@Composable
fun DefaultLoadingView() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize(),
            color = KiiroiAppTheme.colors.colorPrimary
        )
    }
}