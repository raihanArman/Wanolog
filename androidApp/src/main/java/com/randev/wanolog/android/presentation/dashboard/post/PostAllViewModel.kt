package com.randev.wanolog.android.presentation.dashboard.post

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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
class PostAllViewModel(
    private val useCase: GetPostListUseCase
): ViewModel() {

    val postPagination: Flow<PagingData<PostListModel.PostModel>> = Pager(PagingConfig(pageSize = 20)) {
        PostPagingSource(useCase)
    }.flow.cachedIn(viewModelScope)

}