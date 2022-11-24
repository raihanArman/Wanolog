package com.randev.data.datasource.remote

import com.randev.data.response.CharacterListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class CharacterApi(
    private val ktor: HttpClient
): CharactersApiClient {
    override suspend fun fetchCharacterAll(page: Int): CharacterListResponse {
        return ktor.get("api/edge/characters") {
            parameter("page[limit]", 20)
            parameter("sort", "-updatedAt")
            parameter("page[offset]", page)
        }.body()
    }

}