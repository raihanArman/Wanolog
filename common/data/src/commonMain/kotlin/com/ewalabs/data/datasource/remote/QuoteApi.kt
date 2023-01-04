package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.QuoteListResponseItem
import com.ewalabs.data.response.QuoteRandomResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteApi(
    private val ktor: HttpClient
): QuoteApiClient {
    override suspend fun fetchQuotes(page: Int): List<QuoteListResponseItem> {
        return ktor.get("api/quotes") {
            parameter("page", page)
        }.body()
    }

    override suspend fun fetchQuoteRandom(): QuoteRandomResponse {
        return ktor.get("api/random") {
        }.body()
    }
}