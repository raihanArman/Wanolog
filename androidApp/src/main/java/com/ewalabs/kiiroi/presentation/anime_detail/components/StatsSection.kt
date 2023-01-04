package com.ewalabs.kiiroi.presentation.anime_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.domain.model.AnimeDetailModel
import com.ewalabs.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme
import com.ewalabs.kiiroi.R

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
@Composable
fun StatsSection(
    modifier: Modifier = Modifier,
    data: AnimeDetailModel
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (data.data.attributes.averageRating.isNotEmpty()) {
            ItemStatsSection(data = data, modifier = Modifier.weight(1f))
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ItemPopularSection(data = data)
            ItemRatedSection(data = data)
        }
    }
}

@Composable
fun ItemStatsSection(
    modifier: Modifier = Modifier,
    data: AnimeDetailModel
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
               painter = painterResource(id = R.drawable.ic_baseline_thumb_up_alt_24),
               contentDescription = null,
               tint = MovieAppTheme.colors.colorAccent,
               modifier = Modifier
                   .size(30.dp)
            )

            HorizontalSpacer(width = 10.dp)
            Text(
                text = "${Math.round(data.data.attributes.averageRating.toDouble())}%",
                fontSize = 20.sp,
                color = MovieAppTheme.colors.colorAccent,
                style = MovieAppTheme.typography.bold
            )

        }
        Text(
            text = "${data.data.attributes.favoritesCount} favorites",
            fontSize = 14.sp,
            color = Color.Gray,
            style = MovieAppTheme.typography.medium
        )
    }
}


@Composable
fun ItemPopularSection(
    modifier: Modifier = Modifier,
    data: AnimeDetailModel
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_equalizer_24),
                contentDescription = null,
                tint = MovieAppTheme.colors.colorAccent,
                modifier = Modifier
                    .size(25.dp)
            )
            HorizontalSpacer(width = 10.dp)
            Text(
                text = "#${data.data.attributes.popularityRank}",
                fontSize = 20.sp,
                color = Color.Gray,
                style = MovieAppTheme.typography.bold
            )
        }
        Text(
            text = "Most Popular",
            fontSize = 12.sp,
            color = Color.Gray,
            style = MovieAppTheme.typography.bold
        )
    }
}


@Composable
fun ItemRatedSection(
    modifier: Modifier = Modifier,
    data: AnimeDetailModel
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_star_24),
                contentDescription = null,
                tint = MovieAppTheme.colors.colorAccent,
                modifier = Modifier
                    .size(25.dp)
            )
            HorizontalSpacer(width = 10.dp)
            Text(
                text = "#${data.data.attributes.ratingRank}",
                fontSize = 20.sp,
                color = Color.Gray,
                style = MovieAppTheme.typography.bold
            )
        }
        Text(
            text = "Highest Rated",
            fontSize = 12.sp,
            color = Color.Gray,
            style = MovieAppTheme.typography.bold
        )
    }
}
