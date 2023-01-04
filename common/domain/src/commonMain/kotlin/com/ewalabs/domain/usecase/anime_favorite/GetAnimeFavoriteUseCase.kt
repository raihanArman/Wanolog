package com.ewalabs.domain.usecase.anime_favorite

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.AnimeFavoriteModel
import com.ewalabs.domain.repository.AnimeFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 28/12/22
 */
class GetAnimeFavoriteUseCase(
    private val repository: AnimeFavoriteRepository
): FlowUseCase<Nothing?, List<AnimeFavoriteModel>>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<List<AnimeFavoriteModel>>> {
        val fav = repository.getFavorite()
        println("Anime favorite -> $fav")
        return fav
    }
}