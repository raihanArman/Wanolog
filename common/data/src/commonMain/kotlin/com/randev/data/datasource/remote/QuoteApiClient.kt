package com.randev.data.datasource.remote

import com.randev.data.response.PostListResponse
import com.randev.data.response.QuoteListResponseItem
import com.randev.data.response.QuoteRandomResponse

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
interface QuoteApiClient {
    suspend fun fetchQuotes(page: Int): List<QuoteListResponseItem>
    suspend fun fetchQuoteRandom(): QuoteRandomResponse
}