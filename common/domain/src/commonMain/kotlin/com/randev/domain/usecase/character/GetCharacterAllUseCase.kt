package com.randev.domain.usecase.character

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CharacterListModel
import com.randev.domain.repository.CharacterRepository
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