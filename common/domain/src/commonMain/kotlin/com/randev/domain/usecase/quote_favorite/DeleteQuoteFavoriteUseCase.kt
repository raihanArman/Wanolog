package com.randev.domain.usecase.quote_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.repository.AnimeFavoriteRepository
import com.randev.domain.repository.QuoteFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 24/10/22
 */

class DeleteQuoteFavoriteUseCase(
    private val repository: QuoteFavoriteRepository
): FlowUseCase<String?, Long>() {
    override suspend fun execute(parameters: String?): Flow<Resource<Long>> {
        return repository.deleteFavorite(parameters!!)
    }
}