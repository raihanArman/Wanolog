package com.randev.domain.model

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
data class CharacterDetailModel(
    val data: CharacterModel,
    val voices: List<Voices>
) {
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

    data class Voices(
        val id: String,
        val name: String,
        val description: String,
        val image: CoverImageModel
    )
}