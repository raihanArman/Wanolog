package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.QuoteListModel
import com.randev.domain.model.ReviewListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
interface QuoteRepository {
    suspend fun getQuotes(page: Int): Flow<Resource<QuoteListModel>>
}