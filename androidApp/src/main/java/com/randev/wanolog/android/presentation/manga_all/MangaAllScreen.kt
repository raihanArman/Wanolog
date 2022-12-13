package com.randev.wanolog.android.presentation.manga_all

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.wanolog.android.composable.components.bottom_sheet.FilterBottomDialog
import com.randev.wanolog.android.composable.components.button.OutlineButtonCustom
import com.randev.wanolog.android.composable.components.header.HeaderWithBack
import com.randev.wanolog.android.composable.components.progressCircular.ProgressCircularComponent
import com.randev.wanolog.android.composable.components.text_field.SearchTextField
import com.randev.wanolog.android.presentation.anime_all.AnimeAllViewModel
import com.randev.wanolog.android.presentation.home.component.ItemCard
import com.randev.wanolog.android.utils.items
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 24/11/22
 */
@Composable
fun MangaAllScreen(
    viewModel: MangaAllViewModel = getViewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val sortTypeSelected by viewModel.sortTypeFlow.collectAsState()
    val dataManga = viewModel.searchFilterFlow.collectAsLazyPagingItems()

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        columns = GridCells.Fixed(2)
    ) {
        item(span = { GridItemSpan(2) }) {
            HeaderWithBack(
                headerText = "Manga All",
                onBackClick = viewModel::onBackScreen
            )
        }
        item(span = { GridItemSpan(2) }) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                SearchTextField(
                    modifier = Modifier
                        .weight(1f),
                    value = searchQuery,
                    onValueChange = viewModel::updateSearchQuery,
                )
                HorizontalSpacer(width = 10.dp)
                OutlineButtonCustom(
                    onClick = {
                        viewModel.onShowBottomDialog()
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = null
                        )
                    }
                )
            }
        }
        items(dataManga) { data ->
            data?.let {
                ItemCard(
                    title = it.attributes.titles.enJp,
                    image = it.attributes.posterImage.original,
                    onClick = viewModel::onNavigateToDetailsClicked,
                    id = it.id,
                    rating = it.attributes.averageRating
                )
            }
        }
        dataManga.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item(span = { GridItemSpan(2) }) {
                        ProgressCircularComponent(modifier = Modifier.fillMaxWidth())
                    }
                }
                loadState.append is LoadState.Loading -> {
                    item(span = { GridItemSpan(2) }) {
                        ProgressCircularComponent(modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }

    FilterBottomDialog(
        state = viewModel.sheetHandler,
        onApply = viewModel::onApplySortType,
        currentSelected = sortTypeSelected
    )
}