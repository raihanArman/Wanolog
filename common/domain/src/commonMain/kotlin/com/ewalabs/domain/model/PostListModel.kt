package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
data class PostListModel(
    val data: List<PostModel>
): BaseModel() {
    data class PostModel(
        val attributes: AttributesModel,
        val id: String,
        val type: String,
        val user: List<UserPost>,
        val upload: List<UploadModel>,
        val animeManga: List<AnimeMangaPost>
    )

    data class AttributesModel(
        val blocked: Boolean,
        val commentsCount: Int,
        val content: String,
        val contentFormatted: String,
        val createdAt: String,
        val deletedAt: String,
        val editedAt: String,
        val embedUrl: String,
        val lockedAt: String,
        val lockedReason: String,
        val nsfw: Boolean,
        val postLikesCount: Int,
        val spoiler: Boolean,
        val targetInterest: String,
        val topLevelCommentsCount: Int,
        val updatedAt: String,
        val embed: EmbedModel
    )

    data class UserPost(
        val id: String,
        val name: String,
        val avatar: CoverImageModel?,
    )

    data class  CommentsPost(
        val id: String,
        val contentFormatted: String,
        val embed: EmbedModel,
        val likesCount: Int,
        val repliesCount: Int,
        val embedUrl: String
    )

    data class UploadModel(
        val id: String,
        val contentUrl: String
    )

    data class AnimeMangaPost(
        val id: String,
        val type: String,
        val title: String,
        val poster: CoverImageModel
    )

}
