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