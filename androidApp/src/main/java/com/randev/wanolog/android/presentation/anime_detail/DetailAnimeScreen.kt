package com.randev.wanolog.android.presentation.anime_detail

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.randev.domain.model.AnimeDetailModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.R
import com.randev.wanolog.android.composable.components.image.GridImageLayout
import com.randev.wanolog.android.presentation.anime_detail.components.CategorySection
import com.randev.wanolog.android.presentation.anime_detail.components.DescriptionSection
import com.randev.wanolog.android.presentation.anime_detail.components.DetailCategoryItem
import com.randev.wanolog.android.presentation.anime_detail.components.RelatedSection
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 25/11/22
 */
@Composable
fun DetailAnimeScreen(
    viewModel: DetailAnimeViewModel = getViewModel(),
) {

    val state by viewModel.observeDetailState.collectAsState()

    state.data?.let { content ->
        ContentDetail(content)
    }
}

@Composable
fun ContentDetail(content: AnimeDetailModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieAppTheme.colors.colorPrimary)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                DescriptionSection(content)
            }
            item {
                CategorySection(content.categories)
            }
            item {
                EpisodeCount(content)
            }
            item {
                CharacterSection(content)
            }
            item {
                RelatedSection(data = content.relates)
            }
        }
    }
}

@Composable
fun CharacterSection(content: AnimeDetailModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Text(
            text = "Characters",
            fontSize = 20.sp,
            color = Color.White,
            style = MovieAppTheme.typography.bold
        )

        VerticalSpacer(height = 10.dp)
        GridImageLayout(
            url = content.characters.map { it.image.original },
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(5))
                .clip(RoundedCornerShape(5))
                .size(200.dp)
        )
    }
}

@Composable
fun EpisodeCount(content: AnimeDetailModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_timer_24),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier
                .size(50.dp)
        )
        HorizontalSpacer(width = 15.dp)
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "${content.data.attributes.episodeCount} Episodes",
                fontSize = 14.sp,
                color = MovieAppTheme.colors.colorAccent,
                style = MovieAppTheme.typography.medium
            )
            Text(
                text = "${content.data.attributes.episodeLength} minutes each (${content.data.attributes.totalLength / 60} hours total)",
                fontSize = 14.sp,
                color = Color.Gray,
                style = MovieAppTheme.typography.medium
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