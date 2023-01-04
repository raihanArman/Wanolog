package com.ewalabs.data.repository

import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.remote.UserApiClient
import com.ewalabs.data.mapper.UserListMapper
import com.ewalabs.domain.model.UserListModel
import com.ewalabs.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 06/12/22
 */
class UserRepositoryImpl(
    private val mapper: UserListMapper,
    private val userApi: UserApiClient
): UserRepository {
    override suspend fun getCurrentUser(): Flow<Resource<UserListModel>> {
        return object : NetworkResource<UserListModel>() {
            override suspend fun remoteFetch(): UserListModel {
                val result = userApi.getCurrentUser()
                return mapper.map(result)
            }
        }.asFlow()
    }

}