package com.randev.domain.usecase.anime_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.repository.AnimeFavoriteRepository
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