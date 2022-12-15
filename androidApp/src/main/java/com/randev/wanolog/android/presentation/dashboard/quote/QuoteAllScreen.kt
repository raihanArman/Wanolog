package com.randev.wanolog.android.presentation.dashboard.quote

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.randev.wanolog.android.composable.components.grid_view.LazyVerticalStaggeredGrid
import com.randev.wanolog.android.presentation.dashboard.quote.components.ItemQuote
import com.randev.wanolog.android.utils.items
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuoteAllScreen(
    viewModel: QuoteAllViewModel = getViewModel()
) {

    val data = viewModel.quotePagination.collectAsLazyPagingItems()

//    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
//        items(data) {
//
//        }
//    }

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ){
        items(data) { quote ->
            quote?.let {
                ItemQuote(quote = quote)
            }
        }
    }

}