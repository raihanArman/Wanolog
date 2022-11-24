package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.CharactersApiClient
import com.randev.data.mapper.CharacterListMapper
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CharacterListModel
import com.randev.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class CharacterRepositoryImpl(
    private val api: CharactersApiClient,
    private val mapper: CharacterListMapper
): CharacterRepository {
    override suspend fun getCharacterAll(page: Int): Flow<Resource<CharacterListModel>> {
        return object : NetworkResource<CharacterListModel>() {
            override suspend fun remoteFetch(): CharacterListModel {
                val request = api.fetchCharacterAll(page*20)
                return mapper.map(request)
            }
        }.asFlow()
    }
}