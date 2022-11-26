package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.AnimeDetailResponse
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.PosterImageModel
import com.randev.domain.model.TitlesModel

/**
 * @author Raihan Arman
 * @date 26/11/22
 */
class AnimeDetailMapper: BaseMapper<AnimeDetailResponse, AnimeDetailModel>() {
    override fun map(value: AnimeDetailResponse): AnimeDetailModel {
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

        return AnimeDetailModel(
            data = data,
            categories = categories,
            characters = characters,
            reviews = reviews,
            relates = relates
        )

    }
}

fun AnimeDetailResponse.Data?.mapToModel() = AnimeDetailModel.AnimeModel(
    id = this?.id.orEmpty(),
    attributes = AnimeDetailModel.AttributesModel(
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
        episodeCount = this?.attributes?.episodeCount ?: 0,
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
        showType = this?.attributes?.showType.orEmpty(),
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
        totalLength = this?.attributes?.totalLength ?: 0,
        updatedAt = this?.attributes?.updatedAt.orEmpty(),
        userCount = this?.attributes?.userCount ?: 0,
        youtubeVideoId = this?.attributes?.youtubeVideoId.orEmpty(),
        episodeLength = this?.attributes?.episodeLength ?: 0
    )
)

fun AnimeDetailResponse.Included?.mapToCategory() = AnimeDetailModel.CategoryModel(
    id = this?.id.orEmpty(),
    title = this?.attributes?.title.orEmpty()
)

fun AnimeDetailResponse.Included?.mapToCharacter() = AnimeDetailModel.CharacterModel(
    id = this?.id.orEmpty(),
    image = CoverImageModel(
        large = this?.attributes?.image?.large.orEmpty(),
        original = this?.attributes?.image?.original.orEmpty(),
        small = this?.attributes?.image?.small.orEmpty(),
        tiny = this?.attributes?.image?.tiny.orEmpty(),
    ),
    name = this?.attributes?.name.orEmpty()
)

fun AnimeDetailResponse.Included?.mapToReview(
    username: String,
    userId: String,
    avatar: AnimeDetailResponse.Included.Attributes.Avatar?
): AnimeDetailModel.ReviewModel {
    return AnimeDetailModel.ReviewModel(
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

fun AnimeDetailResponse.Included?.mapToRelated() = AnimeDetailModel.RelatedModel(
    id = this?.id.orEmpty(),
    titles = TitlesModel(
        en = this?.attributes?.titles?.en.orEmpty(),
        enJp = this?.attributes?.titles?.enJp.orEmpty(),
        enUs = this?.attributes?.titles?.enUs.orEmpty(),
        jaJp = this?.attributes?.titles?.jaJp.orEmpty(),
    ),
    cover = CoverImageModel(
        large = this?.attributes?.coverImage?.large.orEmpty(),
        original = this?.attributes?.coverImage?.original.orEmpty(),
        small = this?.attributes?.coverImage?.small.orEmpty(),
        tiny = this?.attributes?.coverImage?.tiny.orEmpty(),
    ),
    type = this?.type.orEmpty()
)