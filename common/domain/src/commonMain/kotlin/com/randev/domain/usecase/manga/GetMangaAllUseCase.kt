package com.randev.domain.usecase.manga

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.MangaListModel
import com.randev.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class GetMangaAllUseCase(
    private val repository: MangaRepository
): FlowUseCase<Nothing?, MangaListModel>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<MangaListModel>> {
        return repository.getMangaAll()
    }
}