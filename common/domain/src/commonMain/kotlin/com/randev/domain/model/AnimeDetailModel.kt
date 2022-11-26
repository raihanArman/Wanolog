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

    data class CharacterModel(
        val id: String,
        val image: CoverImageModel,
        val name: String,
    )

    data class CategoryModel(
        val id: String,
        val title: String,
    )

    data class ReviewModel(
        val id: String,
        val content: String,
        val rating: Double,
        val username: String,
        val userId: String,
        val avatar: CoverImageModel
    )

    data class RelatedModel(
        val id: String,
        val type: String,
        val cover: CoverImageModel,
        val titles: TitlesModel
    )

}
