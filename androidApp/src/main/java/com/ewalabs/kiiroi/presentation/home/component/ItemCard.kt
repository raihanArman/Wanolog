package com.ewalabs.kiiroi.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.movieapp_kmm.android.composable.components.image.BaseImageView
import com.ewalabs.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme
import kotlin.math.roundToInt

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

@Composable
fun ItemCard(
    modifier: Modifier = Modifier.fillMaxWidth(),
    id: String,
    title: String,
    image: String,
    rating: String? = null,
    onClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .height(250.dp)
            .clickable {
                onClick(id)
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            BaseImageView(
                url = image,
                modifier = Modifier
                    .fillMaxSize()
            )
            rating?.let {
                if (it.isNotEmpty()) {
                    val rate = it.toDouble().roundToInt()
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Surface(
                            modifier = Modifier
                                .padding(5.dp)
                                .clip(CircleShape),
                            color = Color.Black.copy(alpha = 0.8f)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 10.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(10.dp)
                                )
                                HorizontalSpacer(width = 5.dp)
                                Text(
                                    text = rate.toString(),
                                    color = Color.White,
                                    style = MovieAppTheme.typography.medium,
                                    fontSize = 10.sp
                                )
                            }
                        }
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Black.copy(alpha = 0.8f),
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    color = Color.White,
                    style = MovieAppTheme.typography.bold,
                )
            }
        }
    }
}