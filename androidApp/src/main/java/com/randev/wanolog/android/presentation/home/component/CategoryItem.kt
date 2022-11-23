package com.randev.wanolog.android.presentation.home.component

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
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    title: String,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MovieAppTheme.colors.colorAccent
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 16.sp,
            style = MovieAppTheme.typography.medium,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp)
        )
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    MovieAppTheme() {
        CategoryItem(title = "Comedy")
    }
}