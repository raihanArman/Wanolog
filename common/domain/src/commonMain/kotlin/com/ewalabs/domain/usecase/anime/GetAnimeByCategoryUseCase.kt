package com.ewalabs.domain.usecase.anime

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.AnimeListModel
import com.ewalabs.domain.repository.AnimeRepository
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