package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.QuoteApiClient
import com.randev.data.mapper.QuoteListMapper
import com.randev.domain.model.QuoteListModel
import com.randev.domain.model.ReviewListModel
import com.randev.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteRepositoryImpl(
    private val mapper: QuoteListMapper,
    private val api: QuoteApiClient
): QuoteRepository {
    override suspend fun getQuotes(page: Int): Flow<Resource<QuoteListModel>> {
        return object : NetworkResource<QuoteListModel>() {
            override suspend fun remoteFetch(): QuoteListModel {
                val request = api.fetchQuotes(page)
                return mapper.map(request)
            }
        }.asFlow()
    }
}