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
class GetAnimePopularUseCase(
    private val repository: AnimeRepository
): FlowUseCase<Nothing?, AnimeListModel>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<AnimeListModel>> {
        return repository.getAnimePopular()
    }
}