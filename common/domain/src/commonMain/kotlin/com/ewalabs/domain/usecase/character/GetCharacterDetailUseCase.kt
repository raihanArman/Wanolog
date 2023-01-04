package com.ewalabs.domain.usecase.character

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CharacterDetailModel
import com.ewalabs.domain.repository.CharacterRepository
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