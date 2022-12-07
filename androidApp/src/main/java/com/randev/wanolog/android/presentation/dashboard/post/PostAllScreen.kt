package com.randev.wanolog.android.presentation.dashboard.post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.randev.wanolog.android.presentation.dashboard.post.components.ItemPost
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
@Composable
fun PostAllScreen(
    viewModel: PostAllViewModel = getViewModel()
) {

    val posts = viewModel.postPagination.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(posts) { data ->
            data?.let {
                ItemPost(data = it)
            }
        }
    }

}