package com.randev.domain.usecase.quotes

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.QuoteListModel
import com.randev.domain.repository.QuoteRepository
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