package com.randev.domain.usecase.quote_favorite

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.QuoteFavoriteModel
import com.randev.domain.repository.QuoteFavoriteRepository
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