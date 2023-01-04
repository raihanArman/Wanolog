package com.ewalabs.domain.usecase.manga_favorite

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.MangaFavoriteModel
import com.ewalabs.domain.repository.MangaFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 28/12/22
 */
class GetMangaFavoriteUseCase(
    private val repository: MangaFavoriteRepository
): FlowUseCase<Nothing?, List<MangaFavoriteModel>>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<List<MangaFavoriteModel>>> {
        return repository.getFavorite()
    }
}