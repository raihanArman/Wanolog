package com.ewalabs.domain.usecase.character

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CharacterListModel
import com.ewalabs.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
class GetCharacterAnimeUseCase(
    private val repository: CharacterRepository
): FlowUseCase<CharacterAnimeRequest?, CharacterListModel>() {
    override suspend fun execute(parameters: CharacterAnimeRequest?): Flow<Resource<CharacterListModel>> {
        return repository.getCharacterAnime(parameters!!.page, parameters.id)
    }
}

data class CharacterAnimeRequest(
    val page: Int,
    val id: String
)