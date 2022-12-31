package com.randev.data.response


import com.randev.core.arch.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeListResponse(
    @SerialName("data")
    val data: List<Data?>? = null,
): BaseResponse() {
    @Serializable
    data class Data(
        @SerialName("attributes")
        val attributes: Attributes? = null,
        @SerialName("id")
        val id: String? = null,
        @SerialName("links")
        val links: Links? = null,
        @SerialName("relationships")
        val relationships: Relationships? = null,
        @SerialName("type")
        val type: String? = null
    ) {
        @Serializable
        data class Attributes(
            @SerialName("abbreviatedTitles")
            val abbreviatedTitles: List<String?>?,
            @SerialName("ageRating")
            val ageRating: String?,
            @SerialName("ageRatingGuide")
            val ageRatingGuide: String?,
            @SerialName("averageRating")
            val averageRating: String?,
            @SerialName("canonicalTitle")
            val canonicalTitle: String?,
            @SerialName("coverImage")
            val coverImage: CoverImage?,
            @SerialName("coverImageTopOffset")
            val coverImageTopOffset: Int?,
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("description")
            val description: String?,
            @SerialName("endDate")
            val endDate: String?,
            @SerialName("episodeCount")
            val episodeCount: Int?,
            @SerialName("episodeLength")
            val episodeLength: Int?,
            @SerialName("favoritesCount")
            val favoritesCount: Int?,
            @SerialName("nsfw")
            val nsfw: Boolean?,
            @SerialName("popularityRank")
            val popularityRank: Int?,
            @SerialName("posterImage")
            val posterImage: PosterImage?,
            @SerialName("ratingRank")
            val ratingRank: Int?,
            @SerialName("showType")
            val showType: String?,
            @SerialName("slug")
            val slug: String?,
            @SerialName("startDate")
            val startDate: String?,
            @SerialName("status")
            val status: String?,
            @SerialName("subtype")
            val subtype: String?,
            @SerialName("synopsis")
            val synopsis: String?,
            @SerialName("tba")
            val tba: String?,
            @SerialName("titles")
            val titles: Titles?,
            @SerialName("totalLength")
            val totalLength: Int?,
            @SerialName("updatedAt")
            val updatedAt: String?,
            @SerialName("userCount")
            val userCount: Int?,
            @SerialName("youtubeVideoId")
            val youtubeVideoId: String?
        ) {
            @Serializable
            data class CoverImage(
                @SerialName("large")
                val large: String?,
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
            data class PosterImage(
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
            data class Titles(
                @SerialName("en")
                val en: String? = null,
                @SerialName("en_jp")
                val enJp: String? = null,
                @SerialName("en_us")
                val enUs: String? = null,
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
            @SerialName("animeCharacters")
            val animeCharacters: AnimeCharacters?,
            @SerialName("animeProductions")
            val animeProductions: AnimeProductions?,
            @SerialName("animeStaff")
            val animeStaff: AnimeStaff?,
            @SerialName("castings")
            val castings: Castings?,
            @SerialName("categories")
            val categories: Categories?,
            @SerialName("characters")
            val characters: Characters?,
            @SerialName("episodes")
            val episodes: Episodes?,
            @SerialName("genres")
            val genres: Genres?,
            @SerialName("installments")
            val installments: Installments?,
            @SerialName("mappings")
            val mappings: Mappings?,
            @SerialName("mediaRelationships")
            val mediaRelationships: MediaRelationships?,
            @SerialName("productions")
            val productions: Productions?,
            @SerialName("quotes")
            val quotes: Quotes?,
            @SerialName("reviews")
            val reviews: Reviews?,
            @SerialName("staff")
            val staff: Staff?,
            @SerialName("streamingLinks")
            val streamingLinks: StreamingLinks?
        ) {
            @Serializable
            data class AnimeCharacters(
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
            data class AnimeProductions(
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
            data class AnimeStaff(
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
            data class Categories(
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
            data class Characters(
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
            data class Episodes(
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
            data class Genres(
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
            data class Installments(
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
            data class Mappings(
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
            data class MediaRelationships(
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
            data class Productions(
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

            @Serializable
            data class Reviews(
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
            data class StreamingLinks(
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
}