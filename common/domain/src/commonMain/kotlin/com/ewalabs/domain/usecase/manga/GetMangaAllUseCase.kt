package com.ewalabs.domain.usecase.manga

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.MangaListModel
import com.ewalabs.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class GetMangaAllUseCase(
    private val repository: MangaRepository
): FlowUseCase<Int?, MangaListModel>() {
    override suspend fun execute(parameters: Int?): Flow<Resource<MangaListModel>> {
        return repository.getMangaAll(parameters!!)
    }
}