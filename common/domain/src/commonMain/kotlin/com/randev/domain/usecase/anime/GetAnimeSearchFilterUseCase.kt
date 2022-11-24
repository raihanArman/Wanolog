package com.randev.domain.usecase.anime

import com.randev.core.SortType
import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
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