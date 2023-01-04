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
class GetMangaReviewUseCase(
    private val repository: ReviewRepository
): FlowUseCase<ReviewMangaRequest?, ReviewListModel>() {
    override suspend fun execute(parameters: ReviewMangaRequest?): Flow<Resource<ReviewListModel>> {
        return repository.getReviewByManga(parameters!!.id, parameters.page)
    }
}

data class ReviewMangaRequest(
    val page: Int,
    val id: String
)