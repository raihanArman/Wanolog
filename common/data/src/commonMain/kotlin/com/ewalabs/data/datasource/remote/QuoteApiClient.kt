package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.QuoteListResponseItem
import com.ewalabs.data.response.QuoteRandomResponse

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
interface QuoteApiClient {
    suspend fun fetchQuotes(page: Int): List<QuoteListResponseItem>
    suspend fun fetchQuoteRandom(): QuoteRandomResponse
}