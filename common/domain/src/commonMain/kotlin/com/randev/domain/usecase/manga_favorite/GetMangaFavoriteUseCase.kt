package com.randev.domain.usecase.manga_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.MangaFavoriteModel
import com.randev.domain.repository.MangaFavoriteRepository
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