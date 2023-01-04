package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class MangaDetailModel(
    val data: MangaModel,
    val characters: List<CharacterModel>,
    val categories: List<CategoryModel>,
    val reviews: List<ReviewModel>,
    val relates: List<RelatedModel>,
    var isFavorite: Boolean = false,
): BaseModel() {
    data class MangaModel(
        val attributes: AttributesModel,
        val id: String,
        val type: String
    )

    data class AttributesModel(
        val ageRating: String,
        val ageRatingGuide: String,
        val averageRating: String,
        val canonicalTitle: String,
        val chapterCount: Int,
        val coverImage: CoverImageModel,
        val coverImageTopOffset: Int,
        val createdAt: String,
        val description: String,
        val endDate: String?,
        val favoritesCount: Int,
        val mangaType: String,
        val popularityRank: Int,
        val posterImage: PosterImageModel,
        val ratingRank: Int,
        val slug: String,
        val startDate: String,
        val status: String,
        val subtype: String,
        val synopsis: String,
        val titles: TitlesModel,
        val updatedAt: String,
        val userCount: Int,
        val volumeCount: Int
    )
}
