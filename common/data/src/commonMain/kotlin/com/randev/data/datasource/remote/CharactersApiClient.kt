package com.randev.data.datasource.remote

import com.randev.data.response.AnimeListResponse
import com.randev.data.response.CharacterByTypeListResponse
import com.randev.data.response.CharacterDetailResponse
import com.randev.data.response.CharacterListResponse

/**
 * @author Raihan Arman
 * @date 23/11/22
 */

interface CharactersApiClient {
    suspend fun fetchCharacterAll(page: Int): CharacterListResponse
    suspend fun fetchCharacterManga(page: Int, id: String): CharacterByTypeListResponse
    suspend fun fetchCharacterAnime(page: Int, id: String): CharacterByTypeListResponse
    suspend fun fetchCharacterDetail(id: String): CharacterDetailResponse
}