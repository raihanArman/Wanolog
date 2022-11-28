package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CharacterListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
interface CharacterRepository {
    suspend fun getCharacterAll(page: Int): Flow<Resource<CharacterListModel>>
    suspend fun getCharacterManga(page: Int, id: String): Flow<Resource<CharacterListModel>>
    suspend fun getCharacterAnime(page: Int, id: String): Flow<Resource<CharacterListModel>>
}