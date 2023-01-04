package com.ewalabs.domain.usecase.manga_favorite

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.repository.MangaFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 24/10/22
 */

class DeleteMangaFavoriteUseCase(
    private val repository: MangaFavoriteRepository
): FlowUseCase<Int?, Long>() {
    override suspend fun execute(parameters: Int?): Flow<Resource<Long>> {
        return repository.deleteFavorite(parameters!!.toLong())
    }
}