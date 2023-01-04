package com.ewalabs.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostListResponse(
    @SerialName("data")
    val `data`: List<Data?>?,
    @SerialName("included")
    val included: List<Included?>?,
    @SerialName("links")
    val links: Links?,
    @SerialName("meta")
    val meta: Meta?
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
            @SerialName("blocked")
            val blocked: Boolean?,
            @SerialName("commentsCount")
            val commentsCount: Int?,
            @SerialName("content")
            val content: String?,
            @SerialName("contentFormatted")
            val contentFormatted: String?,
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("deletedAt")
            val deletedAt: String?,
            @SerialName("editedAt")
            val editedAt: String?,
            @SerialName("embed")
            val embed: Embed?,
            @SerialName("embedUrl")
            val embedUrl: String?,
            @SerialName("lockedAt")
            val lockedAt: String?,
            @SerialName("lockedReason")
            val lockedReason: String?,
            @SerialName("nsfw")
            val nsfw: Boolean?,
            @SerialName("postLikesCount")
            val postLikesCount: Int?,
            @SerialName("spoiler")
            val spoiler: Boolean?,
            @SerialName("targetInterest")
            val targetInterest: String?,
            @SerialName("topLevelCommentsCount")
            val topLevelCommentsCount: Int?,
            @SerialName("updatedAt")
            val updatedAt: String?
        ) {
            @Serializable
            data class Embed(
                @SerialName("description")
                val description: String? = null,
                @SerialName("kind")
                val kind: String? = null,
                @SerialName("site")
                val site: Site? = null,
                @SerialName("title")
                val title: String? = null,
                @SerialName("url")
                val url: String? = null,
                @SerialName("video")
                val video: Video? = null
            ) {
                @Serializable
                data class Image(
                    @SerialName("height")
                    val height: String? = null,
                    @SerialName("type")
                    val type: String? = null,
                    @SerialName("url")
                    val url: String? = null,
                    @SerialName("width")
                    val width: String? = null
                )

                @Serializable
                data class Site(
                    @SerialName("name")
                    val name: String? = null,
                    @SerialName("url")
                    val url: String? = null
                )

                @Serializable
                data class Video(
                    @SerialName("height")
                    val height: String?,
                    @SerialName("type")
                    val type: String?,
                    @SerialName("url")
                    val url: String?,
                    @SerialName("width")
                    val width: String?
                )
            }
        }

        @Serializable
        data class Links(
            @SerialName("self")
            val self: String?
        )

        @Serializable
        data class Relationships(
            @SerialName("ama")
            val ama: Ama?,
            @SerialName("comments")
            val comments: Comments?,
            @SerialName("lockedBy")
            val lockedBy: LockedBy?,
            @SerialName("media")
            val media: Media?,
            @SerialName("postLikes")
            val postLikes: PostLikes?,
            @SerialName("spoiledUnit")
            val spoiledUnit: SpoiledUnit?,
            @SerialName("targetGroup")
            val targetGroup: TargetGroup?,
            @SerialName("targetUser")
            val targetUser: TargetUser?,
            @SerialName("uploads")
            val uploads: Uploads?,
            @SerialName("user")
            val user: User?
        ) {
            @Serializable
            data class Ama(
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
            data class Comments(
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
            data class LockedBy(
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
            data class PostLikes(
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
            data class SpoiledUnit(
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
            data class TargetGroup(
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
            data class TargetUser(
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
            data class Uploads(
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
            @SerialName("about")
            val about: String? = null,
            @SerialName("ageRating")
            val ageRating: String? = null,
            @SerialName("ageRatingGuide")
            val ageRatingGuide: String? = null,
            @SerialName("avatar")
            val avatar: Avatar? = null,
            @SerialName("averageRating")
            val averageRating: String? = null,
            @SerialName("birthday")
            val birthday: String? = null,
            @SerialName("canonicalTitle")
            val canonicalTitle: String? = null,
            @SerialName("commentsCount")
            val commentsCount: Int? = null,
            @SerialName("content")
            val content: Content? = null,
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
            @SerialName("feedCompleted")
            val feedCompleted: Boolean? = null,
            @SerialName("followersCount")
            val followersCount: Int? = null,
            @SerialName("followingCount")
            val followingCount: Int? = null,
            @SerialName("gender")
            val gender: String? = null,
            @SerialName("lifeSpentOnAnime")
            val lifeSpentOnAnime: Int? = null,
            @SerialName("likesGivenCount")
            val likesGivenCount: Int? = null,
            @SerialName("likesReceivedCount")
            val likesReceivedCount: Int? = null,
            @SerialName("location")
            val location: String? = null,
            @SerialName("mediaReactionsCount")
            val mediaReactionsCount: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("nextRelease")
            val nextRelease: String? = null,
            @SerialName("nsfw")
            val nsfw: Boolean? = null,
            @SerialName("pastNames")
            val pastNames: List<String?>? = null,
            @SerialName("permissions")
            val permissions: String? = null,
            @SerialName("popularityRank")
            val popularityRank: Int? = null,
            @SerialName("posterImage")
            val posterImage: PosterImage? = null,
            @SerialName("postsCount")
            val postsCount: Int? = null,
            @SerialName("proExpiresAt")
            val proExpiresAt: String? = null,
            @SerialName("proTier")
            val proTier: String? = null,
            @SerialName("profileCompleted")
            val profileCompleted: Boolean? = null,
            @SerialName("ratingRank")
            val ratingRank: Int? = null,
            @SerialName("ratingsCount")
            val ratingsCount: Int? = null,
            @SerialName("reviewsCount")
            val reviewsCount: Int? = null,
            @SerialName("sfwFilterPreference")
            val sfwFilterPreference: String? = null,
            @SerialName("showType")
            val showType: String? = null,
            @SerialName("slug")
            val slug: String? = null,
            @SerialName("startDate")
            val startDate: String? = null,
            @SerialName("status")
            val status: String? = null,
            @SerialName("subscribedToNewsletter")
            val subscribedToNewsletter: Boolean? = null,
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
            @SerialName("uploadOrder")
            val uploadOrder: Int? = null,
            @SerialName("userCount")
            val userCount: Int? = null,
            @SerialName("waifuOrHusbando")
            val waifuOrHusbando: String? = null,
            @SerialName("website")
            val website: String? = null,
            @SerialName("youtubeVideoId")
            val youtubeVideoId: String? = null
        ) {
            @Serializable
            data class Avatar(
                @SerialName("large")
                val large: String? = null,
                @SerialName("large_webp")
                val largeWebp: String? = null,
                @SerialName("medium")
                val medium: String? = null,
                @SerialName("medium_webp")
                val mediumWebp: String? = null,
                @SerialName("meta")
                val meta: Meta? = null,
                @SerialName("original")
                val original: String? = null,
                @SerialName("small")
                val small: String? = null,
                @SerialName("small_webp")
                val smallWebp: String? = null,
                @SerialName("tiny")
                val tiny: String? = null,
                @SerialName("tiny_webp")
                val tinyWebp: String? = null
            ) {
                @Serializable
                data class Meta(
                    @SerialName("dimensions")
                    val dimensions: Dimensions? = null
                ) {
                    @Serializable
                    data class Dimensions(
                        @SerialName("large")
                        val large: Large? = null,
                        @SerialName("large_webp")
                        val largeWebp: LargeWebp? = null,
                        @SerialName("medium")
                        val medium: Medium? = null,
                        @SerialName("medium_webp")
                        val mediumWebp: MediumWebp? = null,
                        @SerialName("small")
                        val small: Small? = null,
                        @SerialName("small_webp")
                        val smallWebp: SmallWebp? = null,
                        @SerialName("tiny")
                        val tiny: Tiny? = null,
                        @SerialName("tiny_webp")
                        val tinyWebp: TinyWebp? = null
                    ) {
                        @Serializable
                        data class Large(
                            @SerialName("height")
                            val height: Int?,
                            @SerialName("width")
                            val width: Int?
                        )

                        @Serializable
                        data class LargeWebp(
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
                        data class MediumWebp(
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
                        data class SmallWebp(
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

                        @Serializable
                        data class TinyWebp(
                            @SerialName("height")
                            val height: Int?,
                            @SerialName("width")
                            val width: Int?
                        )
                    }
                }
            }

            @Serializable
            data class Content(
                @SerialName("meta")
                val meta: Meta?,
                @SerialName("original")
                val original: String?
            ) {
                @Serializable
                data class Meta(
                    @SerialName("dimensions")
                    val dimensions: Dimensions?
                ) {
                    @Serializable
                    class Dimensions
                }
            }

            @Serializable
            data class CoverImage(
                @SerialName("large")
                val large: String? = null,
                @SerialName("large_webp")
                val largeWebp: String? = null,
                @SerialName("meta")
                val meta: Meta? = null,
                @SerialName("original")
                val original: String? = null,
                @SerialName("small")
                val small: String? = null,
                @SerialName("small_webp")
                val smallWebp: String? = null,
                @SerialName("tiny")
                val tiny: String? = null,
                @SerialName("tiny_webp")
                val tinyWebp: String? = null
            ) {
                @Serializable
                data class Meta(
                    @SerialName("dimensions")
                    val dimensions: Dimensions? = null
                ) {
                    @Serializable
                    data class Dimensions(
                        @SerialName("large")
                        val large: Large? = null,
                        @SerialName("large_webp")
                        val largeWebp: LargeWebp? = null,
                        @SerialName("small")
                        val small: Small? = null,
                        @SerialName("small_webp")
                        val smallWebp: SmallWebp? = null,
                        @SerialName("tiny")
                        val tiny: Tiny? = null,
                        @SerialName("tiny_webp")
                        val tinyWebp: TinyWebp? = null
                    ) {
                        @Serializable
                        data class Large(
                            @SerialName("height")
                            val height: Int?,
                            @SerialName("width")
                            val width: Int?
                        )

                        @Serializable
                        data class LargeWebp(
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
                        data class SmallWebp(
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

                        @Serializable
                        data class TinyWebp(
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
                val jaJp: String? = null,
                @SerialName("th_th")
                val thTh: String? = null
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
            val animeCharacters: AnimeCharacters? = null,
            @SerialName("animeProductions")
            val animeProductions: AnimeProductions? = null,
            @SerialName("animeStaff")
            val animeStaff: AnimeStaff? = null,
            @SerialName("blocks")
            val blocks: Blocks? = null,
            @SerialName("castings")
            val castings: Castings? = null,
            @SerialName("categories")
            val categories: Categories? = null,
            @SerialName("categoryFavorites")
            val categoryFavorites: CategoryFavorites? = null,
            @SerialName("characters")
            val characters: Characters? = null,
            @SerialName("episodes")
            val episodes: Episodes? = null,
            @SerialName("favorites")
            val favorites: Favorites? = null,
            @SerialName("followers")
            val followers: Followers? = null,
            @SerialName("following")
            val following: Following? = null,
            @SerialName("genres")
            val genres: Genres? = null,
            @SerialName("installments")
            val installments: Installments? = null,
            @SerialName("libraryEntries")
            val libraryEntries: LibraryEntries? = null,
            @SerialName("linkedAccounts")
            val linkedAccounts: LinkedAccounts? = null,
            @SerialName("mappings")
            val mappings: Mappings? = null,
            @SerialName("mediaRelationships")
            val mediaRelationships: MediaRelationships? = null,
            @SerialName("notificationSettings")
            val notificationSettings: NotificationSettings? = null,
            @SerialName("oneSignalPlayers")
            val oneSignalPlayers: OneSignalPlayers? = null,
            @SerialName("owner")
            val owner: Owner? = null,
            @SerialName("pinnedPost")
            val pinnedPost: PinnedPost? = null,
            @SerialName("post")
            val post: Post? = null,
            @SerialName("productions")
            val productions: Productions? = null,
            @SerialName("profileLinks")
            val profileLinks: ProfileLinks? = null,
            @SerialName("quotes")
            val quotes: Quotes? = null,
            @SerialName("reviews")
            val reviews: Reviews? = null,
            @SerialName("staff")
            val staff: Staff? = null,
            @SerialName("stats")
            val stats: Stats? = null,
            @SerialName("streamingLinks")
            val streamingLinks: StreamingLinks? = null,
            @SerialName("user")
            val user: User? = null,
            @SerialName("userRoles")
            val userRoles: UserRoles? = null,
            @SerialName("waifu")
            val waifu: Waifu? = null
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
            data class Blocks(
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
            data class CategoryFavorites(
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
            data class Favorites(
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
            data class Followers(
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
            data class Following(
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
            data class LibraryEntries(
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
            data class LinkedAccounts(
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
            data class NotificationSettings(
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
            data class OneSignalPlayers(
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
            data class Owner(
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
            data class PinnedPost(
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
            data class Post(
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
            data class ProfileLinks(
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
            data class Stats(
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

            @Serializable
            data class User(
                @SerialName("data")
                val `data`: Data? = null,
                @SerialName("links")
                val links: Links? = null
            ) {
                @Serializable
                data class Data(
                    @SerialName("id")
                    val id: String? = null,
                    @SerialName("type")
                    val type: String? = null
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
            data class UserRoles(
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
            data class Waifu(
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