package com.randev.wanolog.android.presentation.dashboard.post

import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.randev.domain.model.CharacterListModel
import com.randev.domain.model.PostListModel
import com.randev.domain.usecase.post.GetPostListUseCase
import com.randev.wanolog.android.presentation.dashboard.characters.CharacterPagingSource
import com.randev.wanolog.android.utils.SharingCommentAttr
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
class PostAllViewModel(
    private val useCase: GetPostListUseCase,
    private val commentAttr: SharingCommentAttr
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