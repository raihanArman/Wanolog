package com.randev.domain.usecase.review

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.ReviewListModel
import com.randev.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class GetAnimeReviewUseCase(
    private val repository: ReviewRepository
): FlowUseCase<ReviewAnimeRequest?, ReviewListModel>() {
    override suspend fun execute(parameters: ReviewAnimeRequest?): Flow<Resource<ReviewListModel>> {
        return repository.getReviewByAnime(parameters!!.id, parameters.page)
    }
}

data class ReviewAnimeRequest(
    val page: Int,
    val id: String
)