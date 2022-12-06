package com.randev.domain.usecase.user

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.UserListModel
import com.randev.domain.repository.UserRepository
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