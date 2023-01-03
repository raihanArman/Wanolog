package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.MangaListResponse
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.MangaListModel
import com.randev.domain.model.PosterImageModel
import com.randev.domain.model.TitlesModel

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class MangaListMapper: BaseMapper<MangaListResponse, MangaListModel>() {
    override fun map(value: MangaListResponse): MangaListModel {
        return MangaListModel(
            data = value.data?.map {
                it.mapToModel()
            } ?: emptyList()
        ).apply {
            status = true
        }
    }
}

fun MangaListResponse.Data?.mapToModel() = MangaListModel.MangaModel(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    attributes = MangaListModel.AttributesModel(
        ageRating = this?.attributes?.ageRating.orEmpty(),
        ageRatingGuide = this?.attributes?.ageRatingGuide.orEmpty(),
        averageRating = this?.attributes?.averageRating.orEmpty(),
        coverImage = CoverImageModel(
            large = this?.attributes?.coverImage?.large.orEmpty(),
            original = this?.attributes?.coverImage?.original.orEmpty(),
            small = this?.attributes?.coverImage?.small.orEmpty(),
            tiny = this?.attributes?.coverImage?.tiny.orEmpty(),
        ),
        createdAt = this?.attributes?.createdAt.orEmpty(),
        description = this?.attributes?.description.orEmpty(),
        endDate = this?.attributes?.endDate.orEmpty(),
        favoritesCount = this?.attributes?.favoritesCount ?: 0,
        popularityRank = this?.attributes?.popularityRank ?: 0,
        posterImage = PosterImageModel(
            large = this?.attributes?.posterImage?.large.orEmpty(),
            medium = this?.attributes?.posterImage?.medium.orEmpty(),
            original = this?.attributes?.posterImage?.original.orEmpty(),
            small = this?.attributes?.posterImage?.small.orEmpty(),
            tiny = this?.attributes?.posterImage?.tiny.orEmpty(),
        ),
        ratingRank = this?.attributes?.ratingRank ?: 0,
        slug = this?.attributes?.slug.orEmpty(),
        startDate = this?.attributes?.startDate.orEmpty(),
        status = this?.attributes?.status.orEmpty(),
        subtype = this?.attributes?.subtype.orEmpty(),
        synopsis = this?.attributes?.synopsis.orEmpty(),
        titles = TitlesModel(
            en = this?.attributes?.titles?.en.orEmpty(),
            enJp = this?.attributes?.titles?.enJp.orEmpty(),
            enUs = this?.attributes?.titles?.enUs.orEmpty(),
            jaJp = this?.attributes?.titles?.jaJp.orEmpty(),
        ),
        updatedAt = this?.attributes?.updatedAt.orEmpty(),
        userCount = this?.attributes?.userCount ?: 0,
        canonicalTitle = this?.attributes?.canonicalTitle.orEmpty(),
        chapterCount = this?.attributes?.chapterCount ?: 0,
        coverImageTopOffset = this?.attributes?.coverImageTopOffset ?: 0,
        mangaType = this?.attributes?.mangaType.orEmpty(),
        volumeCount = this?.attributes?.volumeCount ?: 0
    )
)