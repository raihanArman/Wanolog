package com.ewalabs.domain.usecase.quotes

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.QuoteListModel
import com.ewalabs.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class GetQuoteListUseCase(
    private val repository: QuoteRepository
): FlowUseCase<Int?, QuoteListModel>() {
    override suspend fun execute(parameters: Int?): Flow<Resource<QuoteListModel>> {
        return repository.getQuotes(parameters!!)
    }
}