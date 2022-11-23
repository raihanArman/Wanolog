package com.randev.wanolog.android.presentation.home.anime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.home.ContentStatus
import com.randev.wanolog.android.presentation.home.ContentType
import com.randev.wanolog.android.presentation.home.HomeState
import com.randev.wanolog.android.presentation.home.anime.components.ContentStatusItem
import com.randev.wanolog.android.presentation.home.component.AnimeAllSection
import com.randev.wanolog.android.presentation.home.component.AnimeTrendingSection
import com.randev.wanolog.android.presentation.home.component.CategorySection
import com.randev.wanolog.android.presentation.home.component.ContentTypeItem
import com.randev.wanolog.android.presentation.home.contentStatusList
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

@Composable
fun AnimeScreen(
    viewModel: AnimeViewModel = getViewModel()
) {

    val state by viewModel.observeHome.collectAsState()
    val status = viewModel.contentStatusState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieAppTheme.colors.colorPrimary),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            item {
                Text(
                    modifier = Modifier.padding(start = 25.dp, top = 25.dp),
                    text = "Anime",
                    fontSize = 24.sp,
                    color = Color.White,
                    style = MovieAppTheme.typography.bold
                )
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
                Box(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp)
                ) {
                    when (status) {
                        ContentStatus.TRENDING -> {
                            TrendingSection(state = state)
                        }
                        ContentStatus.TOP_UPCOMING -> {
                            TopUpcomingSection(state = state)
                        }
                        ContentStatus.TOP_RATING -> {
                            TopRatingSection(state = state)
                        }
                        ContentStatus.POPULAR -> {
                            PopularSection(state = state)
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun TrendingSection(state: AnimeState) {
    state.trendingData?.let {
        AnimeAllSection(data = it)
    }
}

@Composable
fun TopUpcomingSection(state: AnimeState) {
    state.topUpcomingData?.let {
        AnimeAllSection(data = it)
    }
}

@Composable
fun TopRatingSection(state: AnimeState) {
    state.topRatingData?.let {
        AnimeAllSection(data = it)
    }
}

@Composable
fun PopularSection(state: AnimeState) {
    state.popularData?.let {
        AnimeAllSection(data = it)
    }
}