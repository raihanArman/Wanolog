package com.randev.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeDetailResponse(
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
            @SerialName("ratingFrequencies")
            val ratingFrequencies: RatingFrequencies?,
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
            data class RatingFrequencies(
                @SerialName("10")
                val x10: String?,
                @SerialName("11")
                val x11: String?,
                @SerialName("12")
                val x12: String?,
                @SerialName("13")
                val x13: String?,
                @SerialName("14")
                val x14: String?,
                @SerialName("15")
                val x15: String?,
                @SerialName("16")
                val x16: String?,
                @SerialName("17")
                val x17: String?,
                @SerialName("18")
                val x18: String?,
                @SerialName("19")
                val x19: String?,
                @SerialName("2")
                val x2: String?,
                @SerialName("20")
                val x20: String?,
                @SerialName("3")
                val x3: String?,
                @SerialName("4")
                val x4: String?,
                @SerialName("5")
                val x5: String?,
                @SerialName("6")
                val x6: String?,
                @SerialName("7")
                val x7: String?,
                @SerialName("8")
                val x8: String?,
                @SerialName("9")
                val x9: String?
            )

            @Serializable
            data class Titles(
                @SerialName("en")
                val en: String? = null,
                @SerialName("en_jp")
                val enJp: String? = null,
                @SerialName("ja_jp")
                val jaJp: String? = null,
                @SerialName("en_us")
                val enUs: String? = null,
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
            data class AnimeProductions(
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
            @SerialName("abbreviatedTitles")
            val abbreviatedTitles: List<String?>? = null,
            @SerialName("ageRating")
            val ageRating: String? = null,
            @SerialName("ageRatingGuide")
            val ageRatingGuide: String? = null,
            @SerialName("avatar")
            val avatar: Avatar? = null,
            @SerialName("averageRating")
            val averageRating: String? = null,
            @SerialName("canonicalTitle")
            val canonicalTitle: String? = null,
            @SerialName("chapterCount")
            val chapterCount: Int? = null,
            @SerialName("content")
            val content: String? = null,
            @SerialName("coverImage")
            val coverImage: CoverImage? = null,
            @SerialName("coverImageTopOffset")
            val coverImageTopOffset: Int? = null,
            @SerialName("createdAt")
            val createdAt: String? = null,
            @SerialName("description")
            val description: String? = null,
            @SerialName("endDate")
            val endDate: String? = null,
            @SerialName("episodeCount")
            val episodeCount: Int? = null,
            @SerialName("episodeLength")
            val episodeLength: Int? = null,
            @SerialName("favoritesCount")
            val favoritesCount: Int? = null,
            @SerialName("image")
            val image: Image? = null,
            @SerialName("mangaType")
            val mangaType: String? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("nsfw")
            val nsfw: Boolean? = null,
            @SerialName("popularityRank")
            val popularityRank: Int? = null,
            @SerialName("posterImage")
            val posterImage: PosterImage? = null,
            @SerialName("rating")
            val rating: Double? = null,
            @SerialName("ratingFrequencies")
            val ratingFrequencies: RatingFrequencies? = null,
            @SerialName("ratingRank")
            val ratingRank: Int? = null,
            @SerialName("role")
            val role: String? = null,
            @SerialName("serialization")
            val serialization: String? = null,
            @SerialName("showType")
            val showType: String? = null,
            @SerialName("siteName")
            val siteName: String? = null,
            @SerialName("slug")
            val slug: String? = null,
            @SerialName("startDate")
            val startDate: String? = null,
            @SerialName("status")
            val status: String? = null,
            @SerialName("subtype")
            val subtype: String? = null,
            @SerialName("synopsis")
            val synopsis: String? = null,
            @SerialName("tba")
            val tba: String? = null,
            @SerialName("title")
            val title: String? = null,
            @SerialName("titles")
            val titles: Titles? = null,
            @SerialName("totalLength")
            val totalLength: Int? = null,
            @SerialName("updatedAt")
            val updatedAt: String? = null,
            @SerialName("userCount")
            val userCount: Int? = null,
            @SerialName("volumeCount")
            val volumeCount: Int? = null,
            @SerialName("youtubeVideoId")
            val youtubeVideoId: String? = null
        ) {
            @Serializable
            data class Avatar(
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
            data class RatingFrequencies(
                @SerialName("10")
                val x10: String?,
                @SerialName("11")
                val x11: String?,
                @SerialName("12")
                val x12: String?,
                @SerialName("13")
                val x13: String?,
                @SerialName("14")
                val x14: String?,
                @SerialName("15")
                val x15: String?,
                @SerialName("16")
                val x16: String?,
                @SerialName("17")
                val x17: String?,
                @SerialName("18")
                val x18: String?,
                @SerialName("19")
                val x19: String?,
                @SerialName("2")
                val x2: String?,
                @SerialName("20")
                val x20: String?,
                @SerialName("3")
                val x3: String?,
                @SerialName("4")
                val x4: String?,
                @SerialName("5")
                val x5: String?,
                @SerialName("6")
                val x6: String?,
                @SerialName("7")
                val x7: String?,
                @SerialName("8")
                val x8: String?,
                @SerialName("9")
                val x9: String?
            )

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
            @SerialName("anime")
            val anime: Anime?,
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
            @SerialName("chapters")
            val chapters: Chapters?,
            @SerialName("character")
            val character: Character?,
            @SerialName("characters")
            val characters: Characters?,
            @SerialName("destination")
            val destination: Destination?,
            @SerialName("episodes")
            val episodes: Episodes?,
            @SerialName("genres")
            val genres: Genres?,
            @SerialName("installments")
            val installments: Installments?,
            @SerialName("mangaCharacters")
            val mangaCharacters: MangaCharacters?,
            @SerialName("mangaStaff")
            val mangaStaff: MangaStaff?,
            @SerialName("mappings")
            val mappings: Mappings?,
            @SerialName("mediaRelationships")
            val mediaRelationships: MediaRelationships?,
            @SerialName("producer")
            val producer: Producer?,
            @SerialName("productions")
            val productions: Productions?,
            @SerialName("quotes")
            val quotes: Quotes?,
            @SerialName("reviews")
            val reviews: Reviews?,
            @SerialName("source")
            val source: Source?,
            @SerialName("staff")
            val staff: Staff?,
            @SerialName("streamer")
            val streamer: Streamer?,
            @SerialName("streamingLinks")
            val streamingLinks: StreamingLinks?,
            @SerialName("user")
            val user: User?
        ) {
            @Serializable
            data class Anime(
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
            data class Chapters(
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
            data class Destination(
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
            data class MangaCharacters(
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
            data class MangaStaff(
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
            data class Producer(
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
            data class Source(
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
            data class Streamer(
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

            @Serializable
            data class User(
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
        }
    }
}