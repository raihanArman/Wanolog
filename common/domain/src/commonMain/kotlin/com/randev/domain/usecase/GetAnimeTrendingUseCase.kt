package com.randev.domain.usecase

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class GetAnimeTrendingUseCase(
    private val repository: AnimeRepository
): FlowUseCase<Nothing?, AnimeListModel>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<AnimeListModel>> {
        return repository.getAnimeTrending()
    }
}