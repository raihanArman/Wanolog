package com.ewalabs.data.response


import com.ewalabs.core.arch.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryListResponse(
    @SerialName("data")
    val data: List<Data?>?,
): BaseResponse() {
    @Serializable
    data class Data(
        @SerialName("attributes")
        val attributes: Attributes?,
        @SerialName("id")
        val id: String?,
        @SerialName("type")
        val type: String?
    ) {
        @Serializable
        data class Attributes(
            @SerialName("childCount")
            val childCount: Int?,
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("description")
            val description: String?,
            @SerialName("nsfw")
            val nsfw: Boolean?,
            @SerialName("slug")
            val slug: String?,
            @SerialName("title")
            val title: String?,
            @SerialName("totalMediaCount")
            val totalMediaCount: Int?,
            @SerialName("updatedAt")
            val updatedAt: String?
        )
    }
}