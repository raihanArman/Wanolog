package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CharacterDetailModel
import com.ewalabs.domain.model.CharacterListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
interface CharacterRepository {
    suspend fun getCharacterAll(page: Int): Flow<Resource<CharacterListModel>>
    suspend fun getCharacterManga(page: Int, id: String): Flow<Resource<CharacterListModel>>
    suspend fun getCharacterAnime(page: Int, id: String): Flow<Resource<CharacterListModel>>
    suspend fun getCharacterDetail(id: String): Flow<Resource<CharacterDetailModel>>
}