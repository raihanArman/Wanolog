package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.QuoteListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
interface QuoteRepository {
    suspend fun getQuotes(page: Int): Flow<Resource<QuoteListModel>>
}