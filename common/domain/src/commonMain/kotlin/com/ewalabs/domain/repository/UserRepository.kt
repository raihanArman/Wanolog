package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.UserListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 06/12/22
 */
interface UserRepository {
    suspend fun getCurrentUser(): Flow<Resource<UserListModel>>
}