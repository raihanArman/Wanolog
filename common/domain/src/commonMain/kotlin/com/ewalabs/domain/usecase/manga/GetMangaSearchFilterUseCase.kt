package com.ewalabs.domain.usecase.manga

import com.ewalabs.core.SortType
import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.MangaListModel
import com.ewalabs.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class GetMangaSearchFilterUseCase(
    private val repository: MangaRepository
): FlowUseCase<SearchMangaRequest?, MangaListModel>() {
    override suspend fun execute(parameters: SearchMangaRequest?): Flow<Resource<MangaListModel>> {
        return repository.getMangaSearchFilter(parameters?.query.orEmpty(), parameters?.page ?: 1, parameters!!.sortType)
    }
}

data class SearchMangaRequest(
    val query: String,
    val page: Int,
    val sortType: SortType = SortType.NA
)