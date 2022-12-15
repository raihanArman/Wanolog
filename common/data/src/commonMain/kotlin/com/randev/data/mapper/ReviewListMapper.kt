package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.MangaDetailResponse
import com.randev.data.response.ReviewListResponse
import com.randev.domain.model.CommentListModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.ReviewListModel
import com.randev.domain.model.ReviewModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class ReviewListMapper: BaseMapper<ReviewListResponse, ReviewListModel>() {
    override fun map(value: ReviewListResponse): ReviewListModel {
        return ReviewListModel(
            data = value.data?.map {
                it.mapToModel(value.included)
            } ?: emptyList()
        )
    }
}

fun ReviewListResponse.Data?.mapToModel(
    include: List<ReviewListResponse.Included?>?
): ReviewModel {
    val user = include?.find {
        it?.id == this?.relationships?.user?.data?.id
    }
    return ReviewModel(
        id = this?.id.orEmpty(),
        content = this?.attributes?.contentFormatted.orEmpty(),
        rating = this?.attributes?.rating ?: 0.0,
        username = user?.attributes?.name.orEmpty(),
        userId = this?.relationships?.user?.data?.id.orEmpty(),
        avatar = CoverImageModel(
            large = user?.attributes?.avatar?.large.orEmpty(),
            original = user?.attributes?.avatar?.original.orEmpty(),
            small = user?.attributes?.avatar?.small.orEmpty(),
            tiny = user?.attributes?.avatar?.tiny.orEmpty(),
        )
    )
}