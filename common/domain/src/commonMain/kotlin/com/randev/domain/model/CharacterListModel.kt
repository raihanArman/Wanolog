package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 23/11/22
 */

data class CharacterListModel(
    val data: List<CharacterModel>,
): BaseModel(){
    data class CharacterModel(
        val attributes: AttributesModel,
        val id: String,
        val type: String
    )

    data class AttributesModel(
        val canonicalName: String,
        val createdAt: String,
        val description: String,
        val image: CoverImageModel,
        val malId: Int,
        val name: String,
        val names: NamesModel,
        val otherNames: List<String?>,
        val slug: String,
        val updatedAt: String
    )
}