package com.randev.wanolog.android.presentation.review_anime

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
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.composable.components.progressCircular.ProgressCircularComponent
import com.randev.wanolog.android.presentation.anime_detail.components.ReviewItem
import com.randev.wanolog.android.presentation.comments.components.ItemComment
import com.randev.wanolog.android.utils.SheetHandler
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReviewsAnimeScreen(
    sheetHandler: SheetHandler,
    animeId: String,
    viewModel: ReviewsAnimeViewModel = getViewModel()
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
        viewModel.animeId.value = animeId
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
                            style = MovieAppTheme.typography.medium
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