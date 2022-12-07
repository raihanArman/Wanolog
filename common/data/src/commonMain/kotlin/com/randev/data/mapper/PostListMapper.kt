package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.PostListResponse
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.EmbedModel
import com.randev.domain.model.PostListModel

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
class PostListMapper: BaseMapper<PostListResponse, PostListModel>() {
    override fun map(value: PostListResponse): PostListModel {
        return PostListModel(
            data = value.data?.map {
                it.mapToModel(value.included)
            } ?: emptyList()
        )
    }
}

fun PostListResponse.Data?.mapToModel(
    include: List<PostListResponse.Included?>?,
) = PostListModel.PostModel(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    attributes = PostListModel.AttributesModel(
        blocked = this?.attributes?.blocked ?: false,
        commentsCount = this?.attributes?.commentsCount ?: 0,
        content = this?.attributes?.content.orEmpty(),
        contentFormatted = this?.attributes?.contentFormatted.orEmpty(),
        createdAt = this?.attributes?.createdAt.orEmpty(),
        deletedAt = this?.attributes?.deletedAt.orEmpty(),
        editedAt = this?.attributes?.editedAt.orEmpty(),
        embedUrl = this?.attributes?.embedUrl.orEmpty(),
        lockedAt = this?.attributes?.lockedAt.orEmpty(),
        lockedReason = this?.attributes?.lockedReason.orEmpty(),
        nsfw = this?.attributes?.nsfw ?: false,
        postLikesCount = this?.attributes?.postLikesCount ?: 0,
        spoiler = this?.attributes?.spoiler ?: false,
        targetInterest = this?.attributes?.targetInterest.orEmpty(),
        topLevelCommentsCount = this?.attributes?.topLevelCommentsCount ?: 0,
        updatedAt = this?.attributes?.updatedAt.orEmpty(),
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
        )
    ),
    user = include?.filter {
            it?.id == this?.relationships?.user?.data?.id
        }?.map {
            it.mapToUserPost()
        } ?: emptyList(),
    upload =  include?.filter {
            if (!this?.relationships?.uploads?.data.isNullOrEmpty()) {
                it?.id == this?.relationships?.uploads?.data?.get(0)?.id
            } else {
                false
            }
        }?.map {
            it.mapToUpload()
        } ?: emptyList(),
    animeManga = include?.filter {
        it?.type == "anime" || it?.type == "manga"
    }?.map {
        it.mapToAnimeManga()
    } ?: emptyList(),
)

fun PostListResponse.Included?.mapToUserPost() = PostListModel.UserPost(
    id = this?.id.orEmpty(),
    name = this?.attributes?.name.orEmpty(),
    avatar = CoverImageModel(
        large = this?.attributes?.avatar?.large.orEmpty(),
        original = this?.attributes?.avatar?.original.orEmpty(),
        small = this?.attributes?.avatar?.small.orEmpty(),
        tiny = this?.attributes?.avatar?.tiny.orEmpty(),
    )
)

fun PostListResponse.Included?.mapToUpload() = PostListModel.UploadModel(
    id = this?.id.orEmpty(),
    contentUrl = this?.attributes?.content?.original.orEmpty(),
)

fun PostListResponse.Included?.mapToAnimeManga() = PostListModel.AnimeMangaPost(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    title = this?.attributes?.canonicalTitle.orEmpty(),
    poster = CoverImageModel(
        large = this?.attributes?.posterImage?.large.orEmpty(),
        original = this?.attributes?.posterImage?.original.orEmpty(),
        small = this?.attributes?.posterImage?.small.orEmpty(),
        tiny = this?.attributes?.posterImage?.tiny.orEmpty(),
    )
)