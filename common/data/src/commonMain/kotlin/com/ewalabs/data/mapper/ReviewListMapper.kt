package com.ewalabs.data.mapper

import com.ewalabs.core.arch.BaseMapper
import com.ewalabs.data.response.ReviewListResponse
import com.ewalabs.domain.model.CoverImageModel
import com.ewalabs.domain.model.ReviewListModel
import com.ewalabs.domain.model.ReviewModel

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
        ).apply {
            status = true
        }
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