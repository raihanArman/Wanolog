package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.AnimeDetailResponse
import com.randev.data.response.MangaDetailResponse
import com.randev.data.response.MangaListResponse
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.CategoryModel
import com.randev.domain.model.CharacterModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.MangaDetailModel
import com.randev.domain.model.MangaListModel
import com.randev.domain.model.PosterImageModel
import com.randev.domain.model.RelatedModel
import com.randev.domain.model.ReviewModel
import com.randev.domain.model.TitlesModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
class MangaDetailMapper: BaseMapper<MangaDetailResponse, MangaDetailModel>() {
    override fun map(value: MangaDetailResponse): MangaDetailModel {
        val data = value.data.mapToModel()
        val categories = value.included?.filter {
            it?.type == "categories"
        }?.map {
            it.mapToCategory()
        } ?: emptyList()

        val characters = value.included?.filter {
            it?.type == "characters"
        }?.map {
            it.mapToCharacter()
        } ?: emptyList()

        val relates = value.included?.filter {
            it?.type == "anime" || it?.type == "manga"
        }?.map {
            it.mapToRelated()
        } ?: emptyList()

        val reviews = value.included?.filter {
            it?.type == "reviews"
        }?.map { review ->
            val user = value.included.find {
                it?.id == review?.relationships?.user?.data?.id
            }
            review.mapToReview(
                username = user?.attributes?.name.orEmpty(),
                userId = review?.relationships?.user?.data?.id.orEmpty(),
                avatar = user?.attributes?.avatar
            )
        } ?: emptyList()

        return MangaDetailModel(
            data = data,
            categories = categories,
            characters = characters,
            reviews = reviews,
            relates = relates
        )
    }
}

fun MangaDetailResponse.Data?.mapToModel() = MangaDetailModel.MangaModel(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    attributes = MangaDetailModel.AttributesModel(
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
        endDate = this?.attributes?.endDate,
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


fun MangaDetailResponse.Included?.mapToCategory() = CategoryModel(
    id = this?.id.orEmpty(),
    title = this?.attributes?.title.orEmpty()
)

fun MangaDetailResponse.Included?.mapToCharacter() = CharacterModel(
    id = this?.id.orEmpty(),
    image = CoverImageModel(
        large = this?.attributes?.image?.large.orEmpty(),
        original = this?.attributes?.image?.original.orEmpty(),
        small = this?.attributes?.image?.small.orEmpty(),
        tiny = this?.attributes?.image?.tiny.orEmpty(),
    ),
    name = this?.attributes?.name.orEmpty()
)

fun MangaDetailResponse.Included?.mapToReview(
    username: String,
    userId: String,
    avatar: MangaDetailResponse.Included.Attributes.Avatar?
): ReviewModel {
    return ReviewModel(
        id = this?.id.orEmpty(),
        content = this?.attributes?.content.orEmpty(),
        rating = this?.attributes?.rating ?: 0.0,
        username,
        userId,
        CoverImageModel(
            large = avatar?.large.orEmpty(),
            original = avatar?.original.orEmpty(),
            small = avatar?.small.orEmpty(),
            tiny = avatar?.tiny.orEmpty(),
        )
    )
}

fun MangaDetailResponse.Included?.mapToRelated() = RelatedModel(
    id = this?.id.orEmpty(),
    titles = TitlesModel(
        en = this?.attributes?.titles?.en.orEmpty(),
        enJp = this?.attributes?.titles?.enJp.orEmpty(),
        enUs = this?.attributes?.titles?.enUs.orEmpty(),
        jaJp = this?.attributes?.titles?.jaJp.orEmpty(),
    ),
    cover = CoverImageModel(
        large = this?.attributes?.posterImage?.large.orEmpty(),
        original = this?.attributes?.posterImage?.original.orEmpty(),
        small = this?.attributes?.posterImage?.small.orEmpty(),
        tiny = this?.attributes?.posterImage?.tiny.orEmpty(),
    ),
    type = this?.type.orEmpty()
)