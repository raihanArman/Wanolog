package com.randev.wanolog.android.presentation.anime_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.RelatedModel
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.home.component.ItemCard

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
@Composable
fun RelatedSection(
    modifier: Modifier = Modifier,
    data: List<RelatedModel>,
    onClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 25.dp, start = 25.dp, bottom = 25.dp)
    ) {
        Text(
            text = "Related",
            fontSize = 20.sp,
            color = Color.White,
            style = MovieAppTheme.typography.bold
        )
        VerticalSpacer(height = 10.dp)
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(data) {related ->
                ItemCard(
                    id = related.id,
                    title = related.titles.enJp,
                    image = related.cover.original,
                    onClick = onClick,
                    modifier = Modifier
                        .width(150.dp)
                )
            }
        }
    }
}