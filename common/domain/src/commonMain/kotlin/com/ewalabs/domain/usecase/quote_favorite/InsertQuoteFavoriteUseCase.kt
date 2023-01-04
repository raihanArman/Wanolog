package com.ewalabs.domain.usecase.quote_favorite

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.repository.QuoteFavoriteRepository
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
            backgroundColor = parameters?.backgroundColor.orEmpty()
        )
    }
}

data class QuoteFavoriteParams(
    val quote: String,
    val anime: String,
    val character: String,
    val backgroundColor: String
)