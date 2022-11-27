package com.randev.domain.usecase.manga

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.MangaDetailModel
import com.randev.domain.repository.MangaRepository
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