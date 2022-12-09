package com.randev.wanolog.android.presentation.comments

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.comments.components.ItemComment
import com.randev.wanolog.android.utils.SheetHandler
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CommentsScreen(
    sheetState: SheetHandler,
    postId: String,
    viewModel: CommentsViewModel = getViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    BackHandler(enabled = sheetState.handle().isVisible) {
            coroutineScope.launch { sheetState.state {
                hide()
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.postId.value = postId
    }

    val data = viewModel.commentsData.collectAsLazyPagingItems()

    ModalBottomSheetLayout(
        sheetState = sheetState.handle(),
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
                            text = "Comments",
                            fontSize = 16.sp,
                            color = Color.White,
                            style = MovieAppTheme.typography.medium
                        )
                    }
                    items(data) { comment ->
                        comment?.let {
                            ItemComment(data = it)
                        }
                    }
                }
            }
        }
    ) {

    }

}