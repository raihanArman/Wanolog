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