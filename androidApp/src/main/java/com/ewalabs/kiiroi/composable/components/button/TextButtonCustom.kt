package com.ewalabs.kiiroi.composable.components.button

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@Composable
fun TextButtonCustom(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = MovieAppTheme.colors.colorAccent,
            style = MovieAppTheme.typography.bold
        )
    }
}