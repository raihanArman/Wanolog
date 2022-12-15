package com.randev.domain.usecase.manga

import com.randev.core.SortType
import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.MangaListModel
import com.randev.domain.repository.AnimeRepository
import com.randev.domain.repository.MangaRepository
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