package com.randev.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetailResponse(
    @SerialName("data")
    val `data`: Data?,
    @SerialName("included")
    val included: List<Included?>?
) {
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
                val en: String?,
                @SerialName("ja_jp")
                val jaJp: String?
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
                @SerialName("data")
                val `data`: List<Data?>?,
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
    data class Included(
        @SerialName("attributes")
        val attributes: Attributes?,
        @SerialName("id")
        val id: String?,
        @SerialName("links")
        val links: Links?,
        @SerialName("type")
        val type: String?
    ) {
        @Serializable
        data class Attributes(
            @SerialName("createdAt")
            val createdAt: String? = null,
            @SerialName("description")
            val description: String? = null,
            @SerialName("image")
            val image: Image? = null,
            @SerialName("locale")
            val locale: String? = null,
            @SerialName("malId")
            val malId: String? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("role")
            val role: String? = null,
            @SerialName("updatedAt")
            val updatedAt: String? = null
        ) {
            @Serializable
            data class Image(
                @SerialName("large")
                val large: String? = null,
                @SerialName("medium")
                val medium: String? = null,
                @SerialName("meta")
                val meta: Meta? = null,
                @SerialName("original")
                val original: String? = null,
                @SerialName("small")
                val small: String? = null,
                @SerialName("tiny")
                val tiny: String? = null
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
            @SerialName("character")
            val character: Character?,
            @SerialName("licensor")
            val licensor: Licensor?,
            @SerialName("media")
            val media: Media?,
            @SerialName("mediaCharacter")
            val mediaCharacter: MediaCharacter?,
            @SerialName("person")
            val person: Person?,
            @SerialName("staff")
            val staff: Staff?,
            @SerialName("voices")
            val voices: Voices?
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
            data class Character(
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
            data class Licensor(
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
            data class MediaCharacter(
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
            data class Person(
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
            data class Staff(
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
                @SerialName("data")
                val `data`: List<Data?>?,
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
        }
    }
}