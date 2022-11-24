package com.randev.data.datasource.remote

import com.randev.data.response.AnimeListResponse
import com.randev.data.response.CharacterListResponse

/**
 * @author Raihan Arman
 * @date 23/11/22
 */

interface CharactersApiClient {
    suspend fun fetchCharacterAll(page: Int): CharacterListResponse
}