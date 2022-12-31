package com.randev.kiiroi.android.presentation.anime_by_category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.randev.kiiroi.android.composable.components.header.HeaderWithBack
import com.randev.kiiroi.android.composable.components.progressCircular.ProgressCircularComponent
import com.randev.kiiroi.android.presentation.home.component.ItemCard
import com.randev.kiiroi.android.utils.items
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 13/12/22
 */
@Composable
fun AnimeByCategoryScreen(
    viewModel: AnimeByCategoryViewModel = getViewModel()
) {

    val dataAnime = viewModel.animePagination.collectAsLazyPagingItems()

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
                headerText = viewModel.categoryName,
                onBackClick = viewModel::onBackScreen
            )
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

}