package com.ewalabs.domain.usecase.anime

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.AnimeListModel
import com.ewalabs.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class GetAnimeAllUseCase(
    private val repository: AnimeRepository
): FlowUseCase<Int?, AnimeListModel>() {
    override suspend fun execute(parameters: Int?): Flow<Resource<AnimeListModel>> {
        return repository.getAnimeAll(parameters!!)
    }
}