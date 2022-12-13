package com.randev.data.response


import com.randev.core.arch.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterByTypeListResponse(
    @SerialName("data")
    val `data`: List<Data?>?,
    @SerialName("included")
    val included: List<Included?>?,
): BaseResponse() {
    @Serializable
    data class Data(
        @SerialName("attributes")
        val attributes: Attributes?,
        @SerialName("id")
        val id: String?,
        @SerialName("links")
        val links: Links?,
        @SerialName("relationships")
        val relationships: Relationships?,
        @SerialName("type")
        val type: String?
    ) {
        @Serializable
        data class Attributes(
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("role")
            val role: String?,
            @SerialName("updatedAt")
            val updatedAt: String?
        )

        @Serializable
        data class Links(
            @SerialName("self")
            val self: String?
        )

        @Serializable
        data class Relationships(
            @SerialName("character")
            val character: Character?,
            @SerialName("media")
            val media: Media?,
            @SerialName("voices")
            val voices: Voices?
        ) {
            @Serializable
            data class Character(
                @SerialName("data")
                val `data`: Data?,
                @SerialName("links")
                val links: Links?
            ) {
                @Serializable
                data class Data(
                    @SerialName("id")
                    val id: String?,
                    @SerialName("type")
                    val type: String?
                )

                @Serializable
                data class Links(
                    @SerialName("related")
                    val related: String?,
                    @SerialName("self")
                    val self: String?
                )
            }

            @Serializable
            data class Media(
                @SerialName("links")
                val links: Links?
            ) {
                @Serializable
                data class Links(
                    @SerialName("related")
                    val related: String?,
                    @SerialName("self")
                    val self: String?
                )
            }

            @Serializable
            data class Voices(
                @SerialName("links")
                val links: Links?
            ) {
                @Serializable
                data class Links(
                    @SerialName("related")
                    val related: String?,
                    @SerialName("self")
                    val self: String?
                )
            }
        }
    }

    @Serializable
    data class Included(
        @SerialName("attributes")
        val attributes: Attributes?,
        @SerialName("id")
        val id: String?,
        @SerialName("links")
        val links: Links?,
        @SerialName("relationships")
        val relationships: Relationships?,
        @SerialName("type")
        val type: String?
    ) {
        @Serializable
        data class Attributes(
            @SerialName("canonicalName")
            val canonicalName: String?,
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("description")
            val description: String?,
            @SerialName("image")
            val image: Image?,
            @SerialName("malId")
            val malId: Int?,
            @SerialName("name")
            val name: String?,
            @SerialName("names")
            val names: Names?,
            @SerialName("otherNames")
            val otherNames: List<String?>?,
            @SerialName("slug")
            val slug: String?,
            @SerialName("updatedAt")
            val updatedAt: String?
        ) {
            @Serializable
            data class Image(
                @SerialName("large")
                val large: String?,
                @SerialName("medium")
                val medium: String?,
                @SerialName("meta")
                val meta: Meta?,
                @SerialName("original")
                val original: String?,
                @SerialName("small")
                val small: String?,
                @SerialName("tiny")
                val tiny: String?
            ) {
                @Serializable
                data class Meta(
                    @SerialName("dimensions")
                    val dimensions: Dimensions?
                ) {
                    @Serializable
                    data class Dimensions(
                        @SerialName("large")
                        val large: Large?,
                        @SerialName("medium")
                        val medium: Medium?,
                        @SerialName("small")
                        val small: Small?,
                        @SerialName("tiny")
                        val tiny: Tiny?
                    ) {
                        @Serializable
                        data class Large(
                            @SerialName("height")
                            val height: Int?,
                            @SerialName("width")
                            val width: Int?
                        )

                        @Serializable
                        data class Medium(
                            @SerialName("height")
                            val height: Int?,
                            @SerialName("width")
                            val width: Int?
                        )

                        @Serializable
                        data class Small(
                            @SerialName("height")
                            val height: Int?,
                            @SerialName("width")
                            val width: Int?
                        )

                        @Serializable
                        data class Tiny(
                            @SerialName("height")
                            val height: Int?,
                            @SerialName("width")
                            val width: Int?
                        )
                    }
                }
            }

            @Serializable
            data class Names(
                @SerialName("en")
                val en: String? = null,
                @SerialName("ja_jp")
                val jaJp: String? = null
            )
        }

        @Serializable
        data class Links(
            @SerialName("self")
            val self: String?
        )

        @Serializable
        data class Relationships(
            @SerialName("castings")
            val castings: Castings?,
            @SerialName("mediaCharacters")
            val mediaCharacters: MediaCharacters?,
            @SerialName("primaryMedia")
            val primaryMedia: PrimaryMedia?,
            @SerialName("quotes")
            val quotes: Quotes?
        ) {
            @Serializable
            data class Castings(
                @SerialName("links")
                val links: Links?
            ) {
                @Serializable
                data class Links(
                    @SerialName("related")
                    val related: String?,
                    @SerialName("self")
                    val self: String?
                )
            }

            @Serializable
            data class MediaCharacters(
                @SerialName("links")
                val links: Links?
            ) {
                @Serializable
                data class Links(
                    @SerialName("related")
                    val related: String?,
                    @SerialName("self")
                    val self: String?
                )
            }

            @Serializable
            data class PrimaryMedia(
                @SerialName("links")
                val links: Links?
            ) {
                @Serializable
                data class Links(
                    @SerialName("related")
                    val related: String?,
                    @SerialName("self")
                    val self: String?
                )
            }

            @Serializable
            data class Quotes(
                @SerialName("links")
                val links: Links?
            ) {
                @Serializable
                data class Links(
                    @SerialName("related")
                    val related: String?,
                    @SerialName("self")
                    val self: String?
                )
            }
        }
    }

    @Serializable
    data class Links(
        @SerialName("first")
        val first: String?,
        @SerialName("last")
        val last: String?,
        @SerialName("next")
        val next: String?
    )

    @Serializable
    data class Meta(
        @SerialName("count")
        val count: Int?
    )
}