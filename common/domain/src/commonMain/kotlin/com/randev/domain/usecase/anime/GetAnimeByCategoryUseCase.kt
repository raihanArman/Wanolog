package com.randev.domain.usecase.anime

import com.randev.core.SortType
import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 13/12/22
 */
class GetAnimeByCategoryUseCase(
    private val repository: AnimeRepository
): FlowUseCase<AnimeByCategoryRequest?, AnimeListModel>() {
    override suspend fun execute(parameters: AnimeByCategoryRequest?): Flow<Resource<AnimeListModel>> {
        return repository.getAnimeByCategory(page = parameters!!.page, categoryId = parameters.categoryId)
    }
}

data class AnimeByCategoryRequest(
    val page: Int,
    val categoryId: String
)