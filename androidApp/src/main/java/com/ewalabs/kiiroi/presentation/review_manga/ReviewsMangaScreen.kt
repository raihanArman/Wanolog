package com.ewalabs.kiiroi.presentation.review_manga

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.composable.components.progressCircular.ProgressCircularComponent
import com.ewalabs.kiiroi.android.presentation.anime_detail.components.ReviewItem
import com.ewalabs.kiiroi.utils.SheetHandler
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReviewsMangaScreen(
    sheetHandler: SheetHandler,
    mangaId: String,
    viewModel: ReviewsMangaViewModel = getViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    BackHandler(enabled = sheetHandler.handle().isVisible) {
        coroutineScope.launch {
            sheetHandler.state {
                hide()
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.mangaId.value = mangaId
        println("Manga id -> $mangaId")
    }

    val data = viewModel.reviewsData.collectAsLazyPagingItems()

    ModalBottomSheetLayout(
        sheetState = sheetHandler.handle(),
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetContent = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Black,
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    item {
                        Text(
                            modifier = Modifier
                                .padding(10.dp),
                            text = "Reviews",
                            fontSize = 16.sp,
                            color = Color.White,
                            style = KiiroiAppTheme.typography.medium
                        )
                    }
                    items(data) { review ->
                        review?.let {
                            ReviewItem(data = it)
                        }
                    }
                    data.apply {
                        when {
                            loadState.refresh is LoadState.Loading -> {
                                item {
                                    ProgressCircularComponent(modifier = Modifier.fillMaxWidth())
                                }
                            }
                            loadState.append is LoadState.Loading -> {
                                item {
                                    ProgressCircularComponent(modifier = Modifier.fillMaxWidth())
                                }
                            }
                        }
                    }
                }
            }
        }
    ) {

    }

}