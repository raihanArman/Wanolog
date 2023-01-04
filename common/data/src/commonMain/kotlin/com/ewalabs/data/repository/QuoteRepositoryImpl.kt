package com.ewalabs.data.repository

import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.remote.QuoteApiClient
import com.ewalabs.data.mapper.QuoteListMapper
import com.ewalabs.domain.model.QuoteListModel
import com.ewalabs.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteRepositoryImpl(
    private val mapper: QuoteListMapper,
    private val api: QuoteApiClient,
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