package com.randev.domain.usecase.anime

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.repository.AnimeRepository
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