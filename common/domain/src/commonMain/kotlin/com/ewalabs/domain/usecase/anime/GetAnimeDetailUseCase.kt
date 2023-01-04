package com.ewalabs.domain.usecase.anime

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.AnimeDetailModel
import com.ewalabs.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 26/11/22
 */
class GetAnimeDetailUseCase(
    private val repository: AnimeRepository
): FlowUseCase<String?, AnimeDetailModel>() {
    override suspend fun execute(parameters: String?): Flow<Resource<AnimeDetailModel>> {
        return repository.getAnimeDetail(parameters!!)
    }
}