package com.randev.wanolog.android.presentation.dashboard.quote

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.paging.compose.collectAsLazyPagingItems
import com.randev.domain.model.QuoteListModel
import com.randev.wanolog.android.composable.components.card.CardDialogQuote
import com.randev.wanolog.android.composable.components.card.CardDialogQuoteView
import com.randev.wanolog.android.composable.components.card.DialogQuote
import com.randev.wanolog.android.composable.components.grid_view.LazyVerticalStaggeredGrid
import com.randev.wanolog.android.presentation.dashboard.profile.ProfileViewModel
import com.randev.wanolog.android.presentation.dashboard.quote.components.ItemQuote
import com.randev.wanolog.android.utils.ImageUtils
import com.randev.wanolog.android.utils.items
import kotlinx.coroutines.flow.collectLatest
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

//    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
//        items(data) {
//
//        }
//    }

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
                    ItemQuote(quote = quote, onClick = {
                        openDialog = true
                        viewModel.clickQuote(quote)
                    })
                }
            }
        }


        if (uiEvent is QuoteAllViewModel.UIEvent.ShowDialog) {
            if (openDialog) {
                Dialog(onDismissRequest = { openDialog = false }) {
                    DialogQuote(
                        quote = (uiEvent as QuoteAllViewModel.UIEvent.ShowDialog).quote,
                        openDialog = { openDialog = it }
                    )
                }
            }
        }
    }

}
