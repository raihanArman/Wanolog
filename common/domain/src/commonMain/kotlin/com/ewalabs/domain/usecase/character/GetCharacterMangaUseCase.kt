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
class GetCharacterMangaUseCase(
    private val repository: CharacterRepository
): FlowUseCase<CharacterMangaRequest?, CharacterListModel>() {
    override suspend fun execute(parameters: CharacterMangaRequest?): Flow<Resource<CharacterListModel>> {
        return repository.getCharacterManga(parameters!!.page, parameters.id)
    }
}

data class CharacterMangaRequest(
    val page: Int,
    val id: String
)