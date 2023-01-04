package com.ewalabs.kiiroi.presentation.review_manga

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ewalabs.domain.model.ReviewModel
import com.ewalabs.domain.usecase.review.GetMangaReviewUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class ReviewsMangaViewModel(
    private val useCase: GetMangaReviewUseCase,
): ViewModel() {

    val mangaId = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val reviewsData = mangaId.filter {
        it.isNotEmpty()
    }.flatMapLatest {
        println("Mangaaaaa ID -> $it")
        getDataAll(it)
    }

    private fun getDataAll(mangaId: String): Flow<PagingData<ReviewModel>> {
        return Pager(PagingConfig(pageSize = 20)) {
            ReviewsMangaPagingSource(useCase, mangaId)
        }.flow
    }
}