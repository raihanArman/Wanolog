package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
data class MangaListModel(
    val data: List<MangaModel>
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
        val endDate: String,
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
