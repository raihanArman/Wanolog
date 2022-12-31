package com.randev.kiiroi.android.presentation.dashboard.quote.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
@Composable
fun ItemQuote(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    quote: String,
    anime: String,
    backgroundColor: Long
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = anime,
                style = MovieAppTheme.typography.bold,
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
            VerticalSpacer(height = 6.dp)
            Text(
                text = quote,
                style = MovieAppTheme.typography.light,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                maxLines = 4,
                fontStyle = FontStyle.Italic,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}