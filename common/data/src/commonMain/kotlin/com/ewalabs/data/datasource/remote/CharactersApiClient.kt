package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.CharacterByTypeListResponse
import com.ewalabs.data.response.CharacterDetailResponse
import com.ewalabs.data.response.CharacterListResponse

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