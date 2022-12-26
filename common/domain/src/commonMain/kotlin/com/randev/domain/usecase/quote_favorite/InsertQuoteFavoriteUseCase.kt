package com.randev.domain.usecase.quote_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.repository.AnimeFavoriteRepository
import com.randev.domain.repository.QuoteFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/10/22
 */

class InsertQuoteFavoriteUseCase(
    private val repository: QuoteFavoriteRepository
): FlowUseCase<QuoteFavoriteParams?, Long>(){
    override suspend fun execute(parameters: QuoteFavoriteParams?): Flow<Resource<Long>> {
        return repository.insertFavorite(
            quote = parameters?.quote.orEmpty(),
            anime = parameters?.anime.orEmpty(),
            character = parameters?.character.orEmpty(),
        )
    }
}

data class QuoteFavoriteParams(
    val quote: String,
    val anime: String,
    val character: String,
)