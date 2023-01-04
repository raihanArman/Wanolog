package com.ewalabs.kiiroi.presentation.review_anime

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ewalabs.domain.model.ReviewModel
import com.ewalabs.domain.usecase.review.GetAnimeReviewUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class ReviewsAnimeViewModel(
    private val useCase: GetAnimeReviewUseCase,
): ViewModel() {

    val animeId = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val reviewsData = animeId.filter {
        it.isNotEmpty()
    }.flatMapLatest {
        getDataAll(it)
    }

    private fun getDataAll(animeId: String): Flow<PagingData<ReviewModel>> {
        return Pager(PagingConfig(pageSize = 20)) {
            ReviewsAnimePagingSource(useCase, animeId)
        }.flow
    }
}