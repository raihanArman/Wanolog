package com.randev.wanolog.android.presentation.dashboard.post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.randev.wanolog.android.composable.components.notif.ConnectivityStatus
import com.randev.wanolog.android.composable.components.progressCircular.ProgressCircularComponent
import com.randev.wanolog.android.presentation.dashboard.post.components.ItemPost
import com.randev.wanolog.android.utils.connectivityState
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostAllScreen(
    viewModel: PostAllViewModel = getViewModel()
) {

    val posts = viewModel.postPagination.collectAsLazyPagingItems()
    var isLoading by remember {
        mutableStateOf(false)
    }
    val pullRefreshState = rememberPullRefreshState(isLoading, { posts.refresh() })

    Box(
        modifier = Modifier.pullRefresh(pullRefreshState)
    ) {
        PullRefreshIndicator(isLoading, pullRefreshState, Modifier.align(Alignment.TopCenter))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(posts) { data ->
                data?.let {
                    ItemPost(
                        data = data,
                        onClickComment = viewModel::onClickComment
                    )
                }
            }

            posts.apply {
                isLoading = when {
                    loadState.refresh is LoadState.Loading -> {
                        true
                    }
                    loadState.append is LoadState.Loading -> {
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }
    }

}