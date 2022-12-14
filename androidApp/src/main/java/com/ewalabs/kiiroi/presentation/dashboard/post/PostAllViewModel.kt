package com.ewalabs.kiiroi.presentation.dashboard.post

import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ewalabs.domain.model.PostListModel
import com.ewalabs.domain.usecase.post.GetPostListUseCase
import com.ewalabs.kiiroi.utils.SharingCommentAttr
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
class PostAllViewModel(
    private val useCase: GetPostListUseCase,
    private val commentAttr: SharingCommentAttr,
): ViewModel() {

    val postPagination: Flow<PagingData<PostListModel.PostModel>> = Pager(PagingConfig(pageSize = 20)) {
        PostPagingSource(useCase)
    }.flow.cachedIn(viewModelScope)

    @OptIn(ExperimentalMaterialApi::class)
    fun onClickComment(postId: String) {
        viewModelScope.launch {
            commentAttr.postId.value = postId
            commentAttr.sheetHandler.state {
                show()
            }
        }
    }

}