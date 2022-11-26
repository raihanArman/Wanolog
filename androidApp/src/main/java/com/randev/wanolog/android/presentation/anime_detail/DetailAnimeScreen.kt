package com.randev.wanolog.android.presentation.anime_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.R
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 25/11/22
 */
@Composable
fun DetailAnimeScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailAnimeViewModel = getViewModel()
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MovieAppTheme.colors.colorPrimary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentAlignment = Alignment.Center
        ) {
            BaseImageView(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(20.dp),
                contentScale = ContentScale.Crop,
                imageResourceId = R.drawable.jesse_lingard
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colorStops = arrayOf(
                                Pair(0.4f, Transparent),
                                Pair(0.9f, MovieAppTheme.colors.colorPrimary)
                            )
                        )
                    )
            )
            BaseImageView(
                modifier = Modifier
                    .width(170.dp)
                    .height(230.dp),
                contentScale = ContentScale.Crop,
                imageResourceId = R.drawable.jesse_lingard
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
        ) {
            VerticalSpacer(height = 320.dp)
            Text(
                text = "Jesse Lingard",
                style = MovieAppTheme.typography.bold,
                color = Color.White,
                fontSize = 26.sp
            )
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                style = MovieAppTheme.typography.medium,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewDetailAnime() {
    MovieAppTheme{
        DetailAnimeScreen()
    }
}