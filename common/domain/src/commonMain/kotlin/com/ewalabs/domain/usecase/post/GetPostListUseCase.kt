package com.ewalabs.domain.usecase.post

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.PostListModel
import com.ewalabs.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
class GetPostListUseCase(
    private val repository: PostRepository
): FlowUseCase<Int?, PostListModel>() {
    override suspend fun execute(parameters: Int?): Flow<Resource<PostListModel>> {
        return repository.getPosts(parameters!!)
    }
}