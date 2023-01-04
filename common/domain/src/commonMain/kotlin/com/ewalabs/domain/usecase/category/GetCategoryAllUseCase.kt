package com.ewalabs.domain.usecase.category

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CategoryListModel
import com.ewalabs.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

class GetCategoryAllUseCase(
    private val repository: CategoryRepository
): FlowUseCase<Nothing?, CategoryListModel>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<CategoryListModel>> {
        return repository.getCategoryAll()
    }
}