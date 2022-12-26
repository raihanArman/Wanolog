package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 26/11/22
 */
data class AnimeDetailModel(
    val data: AnimeModel,
    val characters: List<CharacterModel>,
    val categories: List<CategoryModel>,
    val reviews: List<ReviewModel>,
    val relates: List<RelatedModel>,
    var isFavorite: Boolean = false,
): BaseModel() {
    data class AnimeModel(
        val attributes: AttributesModel,
        val id: String,
    )

    data class AttributesModel(
        val ageRating: String,
        val ageRatingGuide: String,
        val averageRating: String,
        val coverImage: CoverImageModel,
        val createdAt: String,
        val description: String,
        val endDate: String?,
        val episodeCount: Int,
        val episodeLength: Int,
        val favoritesCount: Int,
        val popularityRank: Int,
        val posterImage: PosterImageModel,
        val ratingRank: Int,
        val showType: String,
        val slug: String,
        val startDate: String,
        val status: String,
        val subtype: String,
        val synopsis: String,
        val titles: TitlesModel,
        val totalLength: Int,
        val updatedAt: String,
        val userCount: Int,
        val youtubeVideoId: String
    )
}
