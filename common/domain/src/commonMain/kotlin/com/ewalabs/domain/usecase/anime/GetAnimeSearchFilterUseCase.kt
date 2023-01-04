package com.ewalabs.domain.usecase.anime

import com.ewalabs.core.SortType
import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.AnimeListModel
import com.ewalabs.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class GetAnimeSearchFilterUseCase(
    private val repository: AnimeRepository
): FlowUseCase<SearchRequest?, AnimeListModel>() {
    override suspend fun execute(parameters: SearchRequest?): Flow<Resource<AnimeListModel>> {
        return repository.getAnimeSearchFilter(parameters?.query.orEmpty(), parameters?.page ?: 1, parameters!!.sortType)
    }
}


data class SearchRequest(
    val query: String,
    val page: Int,
    val sortType: SortType = SortType.NA
)