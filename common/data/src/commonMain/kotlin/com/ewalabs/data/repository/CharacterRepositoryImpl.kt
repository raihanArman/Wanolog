package com.ewalabs.data.repository

import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.remote.CharactersApiClient
import com.ewalabs.data.mapper.CharacterByTypeListMapper
import com.ewalabs.data.mapper.CharacterDetailMapper
import com.ewalabs.data.mapper.CharacterListMapper
import com.ewalabs.domain.model.CharacterDetailModel
import com.ewalabs.domain.model.CharacterListModel
import com.ewalabs.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class CharacterRepositoryImpl(
    private val api: CharactersApiClient,
    private val mapper: CharacterListMapper,
    private val mapperByType: CharacterByTypeListMapper,
    private val mapperDetail: CharacterDetailMapper
): CharacterRepository {
    override suspend fun getCharacterAll(page: Int): Flow<Resource<CharacterListModel>> {
        return object : NetworkResource<CharacterListModel>() {
            override suspend fun remoteFetch(): CharacterListModel {
                val request = api.fetchCharacterAll(page*20)
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getCharacterManga(
        page: Int,
        id: String
    ): Flow<Resource<CharacterListModel>> {
        return object : NetworkResource<CharacterListModel>() {
            override suspend fun remoteFetch(): CharacterListModel {
                val request = api.fetchCharacterManga(page*20, id)
                return mapperByType.map(request)
            }
        }.asFlow()
    }

    override suspend fun getCharacterAnime(
        page: Int,
        id: String
    ): Flow<Resource<CharacterListModel>> {
        return object : NetworkResource<CharacterListModel>() {
            override suspend fun remoteFetch(): CharacterListModel {
                val request = api.fetchCharacterAnime(page*20, id)
                return mapperByType.map(request)
            }
        }.asFlow()
    }

    override suspend fun getCharacterDetail(id: String): Flow<Resource<CharacterDetailModel>> {
        return object : NetworkResource<CharacterDetailModel>() {
            override suspend fun remoteFetch(): CharacterDetailModel {
                val request = api.fetchCharacterDetail(id)
                return mapperDetail.map(request)
            }
        }.asFlow()
    }
}