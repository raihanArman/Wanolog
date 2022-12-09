package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.CommentListResponse
import com.randev.data.response.PostListResponse
import com.randev.domain.model.CommentListModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.EmbedModel
import com.randev.domain.model.PostListModel

/**
 * @author Raihan Arman
 * @date 08/12/22
 */
class CommentListMapper: BaseMapper<CommentListResponse, CommentListModel>() {
    override fun map(value: CommentListResponse): CommentListModel {
        return CommentListModel(
            data = value.data?.map {
                it.mapToModel(value.included)
            } ?: emptyList()
        )
    }
}

fun CommentListResponse.Data?.mapToModel(
    include: List<CommentListResponse.Included?>?,
) = CommentListModel.CommentModel(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    user = include?.filter {
            it?.id == this?.relationships?.user?.data?.id
        }?.map {
            it.mapToUserPost()
        } ?: emptyList(),
    attributes = CommentListModel.CommentModel.AttributesModel(
        blocked = this?.attributes?.blocked ?: false,
        content = this?.attributes?.content.orEmpty(),
        contentFormatted = this?.attributes?.contentFormatted.orEmpty(),
        createdAt = this?.attributes?.createdAt.orEmpty(),
        deletedAt = this?.attributes?.deletedAt.orEmpty(),
        editedAt = this?.attributes?.editedAt.orEmpty(),
        embed = EmbedModel(
            description = this?.attributes?.embed?.description.orEmpty(),
            image = EmbedModel.Image(
                url = this?.attributes?.embed?.url.orEmpty(),
                height = 0,
                width = 0
            ),
            kind = this?.attributes?.embed?.kind.orEmpty(),
            site = EmbedModel.Site(
                name = this?.attributes?.embed?.site?.name.orEmpty(),
                url = this?.attributes?.embed?.site?.url.orEmpty(),
            ),
            title = this?.attributes?.embed?.title.orEmpty(),
            url = this?.attributes?.embed?.url.orEmpty(),
            video = EmbedModel.Video(
                height = this?.attributes?.embed?.video?.height.orEmpty(),
                type = this?.attributes?.embed?.video?.type.orEmpty(),
                url = this?.attributes?.embed?.video?.url.orEmpty(),
                width = this?.attributes?.embed?.video?.width.orEmpty()
            )
        ),
        embedUrl = this?.attributes?.embedUrl.orEmpty(),
        likesCount = this?.attributes?.likesCount ?: 0,
        repliesCount = this?.attributes?.repliesCount ?: 0,
        updatedAt = this?.attributes?.updatedAt.orEmpty()
    )

)

fun CommentListResponse.Included?.mapToUserPost() = PostListModel.UserPost(
    id = this?.id.orEmpty(),
    name = this?.attributes?.name.orEmpty(),
    avatar = CoverImageModel(
        large = this?.attributes?.avatar?.large.orEmpty(),
        original = this?.attributes?.avatar?.original.orEmpty(),
        small = this?.attributes?.avatar?.small.orEmpty(),
        tiny = this?.attributes?.avatar?.tiny.orEmpty(),
    )
)