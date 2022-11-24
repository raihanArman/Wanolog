package com.randev.wanolog.android.composable.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 24/11/22
 */
@Composable
fun OutlineButtonCustom(
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit),
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .height(56.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MovieAppTheme.colors.colorAccent,
            backgroundColor = Color.Transparent
        ),
        onClick = onClick,
        border = BorderStroke(1.dp, MovieAppTheme.colors.colorAccent)
    ) {
        content()
    }
}