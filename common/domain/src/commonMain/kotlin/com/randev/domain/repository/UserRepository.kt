package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.UserListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 06/12/22
 */
interface UserRepository {
    suspend fun getCurrentUser(): Flow<Resource<UserListModel>>
}