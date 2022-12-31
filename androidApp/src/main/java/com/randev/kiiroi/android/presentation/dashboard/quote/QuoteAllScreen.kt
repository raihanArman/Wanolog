package com.randev.kiiroi.android.presentation.dashboard.quote

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.paging.compose.collectAsLazyPagingItems
import com.randev.kiiroi.android.composable.components.card.DialogQuote
import com.randev.kiiroi.android.presentation.dashboard.quote.components.ItemQuote
import com.randev.kiiroi.android.utils.items
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
    val uiEvent by viewModel.eventFlow.collectAsState(QuoteAllViewModel.UIEvent.NoEvent(""))

    var openDialog by remember {
        mutableStateOf(false)
    }

    Box {
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
                    ItemQuote(
                        quote = quote.quote,
                        anime = quote.anime,
                        backgroundColor = quote.backgroundColor,
                        onClick = {
                            openDialog = true
                            viewModel.clickQuote(quote)
                        }
                    )
                }
            }
        }


        if (uiEvent is QuoteAllViewModel.UIEvent.ShowDialog) {
            if (openDialog) {
                Dialog(onDismissRequest = { openDialog = false }) {
                    val data = (uiEvent as QuoteAllViewModel.UIEvent.ShowDialog).quote
                    DialogQuote(
                        quote = data,
                        openDialog = { openDialog = it },
                    )
                }
            }
        }
    }

}
