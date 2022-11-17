package com.randev.wanolog.android.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.home.component.AllSection
import com.randev.wanolog.android.presentation.home.component.HorizontalPagerWithTransition
import com.randev.wanolog.android.presentation.home.component.ItemCard
import com.randev.wanolog.android.presentation.home.component.TrendingSection
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
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
        LazyColumn(
            modifier = Modifier
                .padding(25.dp),
        ) {

            state.trendingData?.let {
                item{
                    TrendingSection(data = it)
                }
            }

            state.allData?.let {
                item {
                    AllSection(data = it)
                }
            }
        }
    }

}