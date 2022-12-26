package com.randev.domain.usecase.manga_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.repository.AnimeFavoriteRepository
import com.randev.domain.repository.MangaFavoriteRepository
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