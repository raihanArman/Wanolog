package com.randev.domain.usecase.character

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CharacterDetailModel
import com.randev.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
class GetCharacterDetailUseCase(
    private val repository: CharacterRepository
): FlowUseCase<String?, CharacterDetailModel>() {
    override suspend fun execute(parameters: String?): Flow<Resource<CharacterDetailModel>> {
        return repository.getCharacterDetail(parameters!!)
    }
}