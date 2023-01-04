package com.ewalabs.domain.usecase.manga

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.MangaListModel
import com.ewalabs.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 13/12/22
 */
class GetMangaByCategoryUseCase(
    private val repository: MangaRepository
): FlowUseCase<MangaByCategoryRequest?, MangaListModel>() {
    override suspend fun execute(parameters: MangaByCategoryRequest?): Flow<Resource<MangaListModel>> {
        return repository.getMangaByCategory(page = parameters!!.page, categoryId = parameters.categoryId)
    }
}

data class MangaByCategoryRequest(
    val page: Int,
    val categoryId: String
)