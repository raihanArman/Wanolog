package com.randev.kiiroi.data

import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.PosterImageModel
import com.randev.domain.model.TitlesModel

/**
 * @author Raihan Arman
 * @date 02/01/23
 */

fun fakeDataAnime(): List<AnimeListModel.AnimeModel> = listOf(
    AnimeListModel.AnimeModel(
        attributes = AnimeListModel.AttributesModel(
            ageRating = "",
            ageRatingGuide = "",
            averageRating = "85.70",
            coverImage = CoverImageModel(
                "","","",""
            ),
            createdAt = "",
            description = "",
            endDate = "",
            episodeCount = 1,
            episodeLength = 1,
            favoritesCount = 1,
            popularityRank = 1,
            posterImage = PosterImageModel("", "", "", "", ""),
            ratingRank = 1,
            showType = "",
            slug = "",
            startDate = "",
            status = "",
            subtype = "",
            synopsis = "",
            titles = TitlesModel("", "Naruto", "", ""),
            totalLength = 1,
            updatedAt = "",
            userCount = 1,
            youtubeVideoId = ""
        ),
        id = "1",
        type = ""
    ),
    AnimeListModel.AnimeModel(
        attributes = AnimeListModel.AttributesModel(
            ageRating = "",
            ageRatingGuide = "",
            averageRating = "86.70",
            coverImage = CoverImageModel(
                "","","",""
            ),
            createdAt = "",
            description = "",
            endDate = "",
            episodeCount = 1,
            episodeLength = 1,
            favoritesCount = 1,
            popularityRank = 1,
            posterImage = PosterImageModel("", "", "", "", ""),
            ratingRank = 1,
            showType = "",
            slug = "",
            startDate = "",
            status = "",
            subtype = "",
            synopsis = "",
            titles = TitlesModel("", "One Piece", "", ""),
            totalLength = 1,
            updatedAt = "",
            userCount = 1,
            youtubeVideoId = ""
        ),
        id = "1",
        type = ""
    )
)