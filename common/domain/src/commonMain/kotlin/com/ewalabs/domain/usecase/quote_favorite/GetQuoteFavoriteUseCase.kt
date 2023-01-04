package com.ewalabs.domain.usecase.quote_favorite

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.QuoteFavoriteModel
import com.ewalabs.domain.repository.QuoteFavoriteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 28/12/22
 */
class GetQuoteFavoriteUseCase(
    private val repository: QuoteFavoriteRepository
): FlowUseCase<Nothing?, List<QuoteFavoriteModel>>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<List<QuoteFavoriteModel>>> {
        return repository.getFavorite()
    }
}