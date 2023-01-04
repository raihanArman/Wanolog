package com.ewalabs.domain.usecase.manga

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.MangaDetailModel
import com.ewalabs.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
class GetMangaDetailUseCase(
    private val repository: MangaRepository
): FlowUseCase<String?, MangaDetailModel>() {
    override suspend fun execute(parameters: String?): Flow<Resource<MangaDetailModel>> {
        return repository.getMangaDetail(parameters!!)
    }
}