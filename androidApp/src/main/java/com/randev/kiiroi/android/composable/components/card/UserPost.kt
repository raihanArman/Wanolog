package com.randev.kiiroi.android.composable.components.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 09/12/22
 */

@Composable
fun UserPost(
    name: String,
    image: String,
    rangeTime: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, end = 10.dp, start = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BaseImageView(
            url = image,
            modifier = Modifier
                .clip(CircleShape)
                .size(25.dp),
            contentScale = ContentScale.Crop
        )
        HorizontalSpacer(width = 10.dp)
        Column(
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = name,
                color = Color.White,
                style = MovieAppTheme.typography.medium,
                fontSize = 11.sp
            )
            Text(
                text = rangeTime,
                color = Color.White,
                style = MovieAppTheme.typography.light,
                fontSize = 8.sp
            )
        }
    }
}