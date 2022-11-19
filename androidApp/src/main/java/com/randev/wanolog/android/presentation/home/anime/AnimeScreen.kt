package com.randev.wanolog.android.presentation.home.anime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.home.component.AnimeAllSection
import com.randev.wanolog.android.presentation.home.component.AnimeTrendingSection
import com.randev.wanolog.android.presentation.home.component.CategorySection
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

    LaunchedEffect(key1 = true) {
        viewModel.getHome()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieAppTheme.colors.colorPrimary),
    ) {
        LazyColumn{

            state.trendingData?.let {
                item{
                    AnimeTrendingSection(data = it)
                }
            }

            state.allData?.let {
                item {
                    AnimeAllSection(data = it)
                }
            }
        }
    }

}