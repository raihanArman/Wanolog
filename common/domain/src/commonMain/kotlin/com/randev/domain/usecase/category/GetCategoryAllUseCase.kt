package com.randev.domain.usecase.category

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CategoryListModel
import com.randev.domain.repository.CategoryRepository
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