package com.ewalabs.domain.usecase.user

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.UserListModel
import com.ewalabs.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 06/12/22
 */
class GetCurrentUserUseCase(
    private val repository: UserRepository
): FlowUseCase<Nothing?, UserListModel>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<UserListModel>> {
        return repository.getCurrentUser()
    }
}