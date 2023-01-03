package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 08/12/22
 */
data class CommentListModel(
    val data: List<CommentModel>
): BaseModel() {
    data class CommentModel(
        val attributes: AttributesModel,
        val id: String,
        val type: String,
        val user: List<PostListModel.UserPost>,
    ) {
        data class AttributesModel(
            val blocked: Boolean,
            val content: String,
            val contentFormatted: String,
            val createdAt: String,
            val deletedAt: String,
            val editedAt: String,
            val embed: EmbedModel,
            val embedUrl: String,
            val likesCount: Int,
            val repliesCount: Int,
            val updatedAt: String
        )
    }
}
