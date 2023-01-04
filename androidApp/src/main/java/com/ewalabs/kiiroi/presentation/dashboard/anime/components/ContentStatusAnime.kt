package com.ewalabs.kiiroi.presentation.dashboard.anime.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme
import com.ewalabs.kiiroi.presentation.home.ContentStatus

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

@Composable
fun ContentStatusItem(
    modifier: Modifier = Modifier,
    contentTypeSelected: ContentStatus,
    contentTypeCurrent: ContentStatus,
    onClick: () -> Unit
) {
    if (contentTypeSelected == contentTypeCurrent) {
        Surface(
            shape = CircleShape,
            color = Color.White.copy(0.1f),
            border = BorderStroke(1.dp, color = Color.White),
            modifier = modifier
                .clickable {
                    onClick()
                }
        ) {
            Text(
                text = contentTypeCurrent.value,
                color = Color.White,
                fontSize = 16.sp,
                style = MovieAppTheme.typography.medium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
            )
        }
    } else {
        Text(text = contentTypeCurrent.value,
            color = Color.White,
            fontSize = 16.sp,
            style = MovieAppTheme.typography.medium,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
                .clickable {
                    onClick()
                }
        )
    }
}

@Preview
@Composable
fun PreviewContentType() {
    MovieAppTheme {
        Row() {
        }
    }
}