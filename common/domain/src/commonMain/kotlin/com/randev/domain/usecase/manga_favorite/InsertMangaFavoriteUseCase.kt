package com.randev.domain.usecase.manga_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.repository.AnimeFavoriteRepository
import com.randev.domain.repository.MangaFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/10/22
 */

class InsertMangaFavoriteUseCase(
    private val repository: MangaFavoriteRepository
): FlowUseCase<MangaFavoriteParams?, Long>(){
    override suspend fun execute(parameters: MangaFavoriteParams?): Flow<Resource<Long>> {
        return repository.insertFavorite(
            id = parameters?.id ?: 0,
            title = parameters?.title.orEmpty(),
            poster = parameters?.poster.orEmpty(),
            rate = parameters?.rate.orEmpty(),
        )
    }
}

data class MangaFavoriteParams(
    val id: Long,
    val title: String,
    val poster: String,
    val rate: String,
)