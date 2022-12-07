package com.randev.domain.usecase.post

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.PostListModel
import com.randev.domain.repository.PostRepository
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