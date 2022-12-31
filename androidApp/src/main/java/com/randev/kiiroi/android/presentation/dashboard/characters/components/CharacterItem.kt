package com.randev.kiiroi.android.presentation.dashboard.characters

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.CharacterListModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.Colors
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@Composable
fun CharacterItem(
    modifier: Modifier = Modifier.fillMaxWidth(),
    data: CharacterListModel.CharacterModel
) {

    val gradient =
        Brush.horizontalGradient(listOf(Colors.sunGlow, Colors.sunGlow2))
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
    )
    Card(
        modifier = modifier
            .height(170.dp),
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(top = 25.dp, bottom = 25.dp, start = 5.dp, end = 5.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseImageView(
                url = data.attributes.image.original,
                modifier = Modifier
                    .drawBehind {
                        drawCircle(gradient, style = Stroke(10f))
                    }
                    .clip(CircleShape)
                    .size(70.dp)
            )
            VerticalSpacer(height = 10.dp)
            Text(
                text = data.attributes.names.en,
                fontSize = 12.sp,
                color = Color.White,
                style = MovieAppTheme.typography.bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            if (data.attributes.otherNames.isNotEmpty()) {
                Text(
                    text = data.attributes.otherNames[0].orEmpty(),
                    fontSize = 10.sp,
                    color = Color.White,
                    style = MovieAppTheme.typography.medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview
@Composable
fun CharacterItemPreview() {
    MovieAppTheme {
//        CharacterItem()
    }
}