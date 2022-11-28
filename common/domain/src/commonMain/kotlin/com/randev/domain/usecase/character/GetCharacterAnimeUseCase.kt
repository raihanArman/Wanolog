package com.randev.domain.usecase.character

import com.randev.core.SortType
import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CharacterListModel
import com.randev.domain.repository.CharacterRepository
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