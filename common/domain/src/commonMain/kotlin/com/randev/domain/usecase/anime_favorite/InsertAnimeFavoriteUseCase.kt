package com.randev.domain.usecase.anime_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.repository.AnimeFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/10/22
 */

class InsertAnimeFavoriteUseCase(
    private val repository: AnimeFavoriteRepository
): FlowUseCase<AnimeFavoriteParams?, Long>(){
    override suspend fun execute(parameters: AnimeFavoriteParams?): Flow<Resource<Long>> {
        return repository.insertFavorite(
            id = parameters?.id ?: 0,
            title = parameters?.title.orEmpty(),
            poster = parameters?.poster.orEmpty(),
            rate = parameters?.rate.orEmpty(),
        )
    }
}

data class AnimeFavoriteParams(
    val id: Long,
    val title: String,
    val poster: String,
    val rate: String,
)