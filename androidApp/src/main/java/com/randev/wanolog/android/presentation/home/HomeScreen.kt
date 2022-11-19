package com.randev.wanolog.android.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.home.anime.AnimeScreen
import com.randev.wanolog.android.presentation.home.anime.AnimeViewModel
import com.randev.wanolog.android.presentation.home.component.CategorySection
import com.randev.wanolog.android.presentation.home.component.ContentTypeItem
import com.randev.wanolog.android.presentation.home.manga.MangaScreen
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {

    val state by viewModel.observeCategory.collectAsState()
    val contentTypeSelected = viewModel.contentTypeState


    LaunchedEffect(key1 = true) {
        viewModel.getCategory()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieAppTheme.colors.colorPrimary),
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp),
        ) {
            state.categoryData?.let {
                CategorySection(data = it)
            }
            VerticalSpacer(height = 25.dp)
            Row {
                ContentTypeItem(
                    contentTypeCurrent = ContentType.ANIME,
                    contentTypeSelected = contentTypeSelected,
                    onClick = {
                        viewModel.changeContentType(ContentType.ANIME)
                    }
                )
                ContentTypeItem(
                    contentTypeCurrent = ContentType.MANGA,
                    contentTypeSelected = contentTypeSelected,
                    onClick = {
                        viewModel.changeContentType(ContentType.MANGA)
                    }
                )
            }
            if (contentTypeSelected == ContentType.ANIME) {
                AnimeScreen()
            } else {
                MangaScreen()
            }
        }
    }

}