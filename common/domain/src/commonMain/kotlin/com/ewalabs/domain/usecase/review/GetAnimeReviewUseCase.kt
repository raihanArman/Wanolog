package com.ewalabs.domain.usecase.review

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.ReviewListModel
import com.ewalabs.domain.repository.ReviewRepository
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