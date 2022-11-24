package com.randev.domain.usecase.anime

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
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