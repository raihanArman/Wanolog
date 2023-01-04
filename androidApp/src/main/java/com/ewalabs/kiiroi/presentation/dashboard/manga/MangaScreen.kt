package com.ewalabs.kiiroi.presentation.dashboard.manga

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.composable.components.button.TextButtonCustom
import com.ewalabs.kiiroi.composable.components.progressCircular.ProgressCircularComponent
import com.ewalabs.kiiroi.presentation.home.ContentStatus
import com.ewalabs.kiiroi.presentation.dashboard.anime.components.ContentStatusItem
import com.ewalabs.kiiroi.android.presentation.home.component.MangaAllSection
import com.ewalabs.kiiroi.presentation.home.contentStatusList
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MangaScreen(
    viewModel: MangaViewModel = getViewModel()
) {

    val state by viewModel.observeManga.collectAsState()
    val status = viewModel.contentStatusState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(KiiroiAppTheme.colors.colorPrimary),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        )  {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, top = 25.dp, end = 25.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Manga",
                        fontSize = 24.sp,
                        color = Color.White,
                        style = KiiroiAppTheme.typography.bold
                    )
                    TextButtonCustom(
                        text = "See All",
                        onClick = viewModel::onNavigateToMangaAll
                    )
                }
            }
            item {
                LazyRow(
                    modifier = Modifier
                        .padding(start = 25.dp)
                ) {
                    items(contentStatusList()) { contentStatus ->
                        ContentStatusItem(
                            contentTypeCurrent = contentStatus,
                            contentTypeSelected = status,
                            onClick = {
                                viewModel.changeContentContentStatus(contentStatus)
                            }
                        )
                    }
                }
            }
            item {
                AnimatedContent(
                    targetState = status,
                    transitionSpec = {
                        slideIntoContainer(
                            animationSpec = tween(300),
                            towards = AnimatedContentScope.SlideDirection.Right
                        ).with(
                            slideOutOfContainer(
                                animationSpec = tween(300),
                                towards = AnimatedContentScope.SlideDirection.Left
                            )
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 25.dp, end = 25.dp)
                    ) {
                        when (status) {
                            ContentStatus.TRENDING -> {
                                TrendingSection(state = state, onClick = viewModel::onNavigateToDetailsClicked)
                            }
                            ContentStatus.TOP_UPCOMING -> {
                                TopUpcomingSection(state = state, onClick = viewModel::onNavigateToDetailsClicked)
                            }
                            ContentStatus.TOP_RATING -> {
                                TopRatingSection(state = state, onClick = viewModel::onNavigateToDetailsClicked)
                            }
                            ContentStatus.POPULAR -> {
                                PopularSection(state = state, onClick = viewModel::onNavigateToDetailsClicked)
                            }
                        }
                    }
                }
            }
            item {
                if (state.isLoading) {
                    ProgressCircularComponent()
                }
            }
        }

    }
}

@Composable
fun TrendingSection(
    state: MangaState,
    onClick: (String) -> Unit) {
    state.trendingData?.let {
        MangaAllSection(data = it, onClick = onClick)
    }
}

@Composable
fun TopUpcomingSection(
    state: MangaState,
    onClick: (String) -> Unit
) {
    state.topUpcomingData?.let {
        MangaAllSection(data = it, onClick = onClick)
    }
}

@Composable
fun TopRatingSection(
    state: MangaState,
    onClick: (String) -> Unit
) {
    state.topRatingData?.let {
        MangaAllSection(data = it, onClick = onClick)
    }
}

@Composable
fun PopularSection(
    state: MangaState,
    onClick: (String) -> Unit
) {
    state.popularData?.let {
        MangaAllSection(data = it, onClick = onClick)
    }
}

@Preview
@Composable
fun PreviewMangaScreen() {

}