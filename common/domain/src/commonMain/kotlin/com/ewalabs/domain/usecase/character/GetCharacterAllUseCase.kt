package com.ewalabs.domain.usecase.character

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CharacterListModel
import com.ewalabs.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class GetCharacterAllUseCase(
    private val repository: CharacterRepository
): FlowUseCase<Int?, CharacterListModel>() {
    override suspend fun execute(parameters: Int?): Flow<Resource<CharacterListModel>> {
        return repository.getCharacterAll(parameters!!)
    }
}