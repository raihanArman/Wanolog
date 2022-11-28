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