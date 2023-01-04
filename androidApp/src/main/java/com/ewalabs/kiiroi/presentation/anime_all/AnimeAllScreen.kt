package com.ewalabs.kiiroi.presentation.anime_all

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
import com.ewalabs.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.ewalabs.kiiroi.composable.components.button.OutlineButtonCustom
import com.ewalabs.kiiroi.composable.components.text_field.SearchTextField
import com.ewalabs.kiiroi.presentation.home.component.ItemCard
import com.ewalabs.kiiroi.utils.items
import com.ewalabs.kiiroi.composable.components.bottom_sheet.FilterBottomDialog
import com.ewalabs.kiiroi.composable.components.header.HeaderWithBack
import com.ewalabs.kiiroi.composable.components.progressCircular.ProgressCircularComponent
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@Composable
fun AnimeAllScreen(
    viewModel: AnimeAllViewModel = getViewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val sortTypeSelected by viewModel.sortTypeFlow.collectAsState()
    val dataAnime = viewModel.searchFilterFlow.collectAsLazyPagingItems()

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
                headerText = "Anime All",
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
        items(dataAnime) { data ->
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
        dataAnime.apply {
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