package com.randev.data.datasource.remote

import com.randev.data.response.CharacterByTypeListResponse
import com.randev.data.response.CharacterDetailResponse
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

    override suspend fun fetchCharacterManga(page: Int, id: String): CharacterByTypeListResponse {
        return ktor.get("api/edge/manga/$id/characters") {
            parameter("page[limit]", 20)
            parameter("page[offset]", page)
            parameter("include", "character")
        }.body()
    }

    override suspend fun fetchCharacterAnime(page: Int, id: String): CharacterByTypeListResponse {
        return ktor.get("api/edge/anime/$id/characters") {
            parameter("page[limit]", 20)
            parameter("page[offset]", page)
            parameter("include", "character")
        }.body()
    }

    override suspend fun fetchCharacterDetail(id: String): CharacterDetailResponse {
        return ktor.get("api/edge/characters/$id") {
            parameter("include", "mediaCharacters.voices.person")
        }.body()
    }

}