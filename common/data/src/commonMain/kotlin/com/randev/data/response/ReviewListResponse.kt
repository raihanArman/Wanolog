package com.randev.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewListResponse(
    @SerialName("data")
    val `data`: List<Data?>?,
    @SerialName("included")
    val included: List<Included?>? = null,
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
            @SerialName("content")
            val content: String?,
            @SerialName("contentFormatted")
            val contentFormatted: String?,
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("likesCount")
            val likesCount: Int?,
            @SerialName("progress")
            val progress: Int?,
            @SerialName("rating")
            val rating: Double?,
            @SerialName("source")
            val source: String?,
            @SerialName("spoiler")
            val spoiler: Boolean?,
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
            @SerialName("libraryEntry")
            val libraryEntry: LibraryEntry?,
            @SerialName("media")
            val media: Media?,
            @SerialName("user")
            val user: User?
        ) {
            @Serializable
            data class LibraryEntry(
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
            @SerialName("about")
            val about: String?,
            @SerialName("avatar")
            val avatar: Avatar?,
            @SerialName("birthday")
            val birthday: String?,
            @SerialName("commentsCount")
            val commentsCount: Int?,
            @SerialName("coverImage")
            val coverImage: CoverImage?,
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("favoritesCount")
            val favoritesCount: Int?,
            @SerialName("feedCompleted")
            val feedCompleted: Boolean?,
            @SerialName("followersCount")
            val followersCount: Int?,
            @SerialName("followingCount")
            val followingCount: Int?,
            @SerialName("gender")
            val gender: String?,
            @SerialName("lifeSpentOnAnime")
            val lifeSpentOnAnime: Int?,
            @SerialName("likesGivenCount")
            val likesGivenCount: Int?,
            @SerialName("likesReceivedCount")
            val likesReceivedCount: Int?,
            @SerialName("location")
            val location: String?,
            @SerialName("mediaReactionsCount")
            val mediaReactionsCount: Int?,
            @SerialName("name")
            val name: String?,
            @SerialName("pastNames")
            val pastNames: List<String?>?,
            @SerialName("permissions")
            val permissions: String?,
            @SerialName("postsCount")
            val postsCount: Int?,
            @SerialName("proExpiresAt")
            val proExpiresAt: String?,
            @SerialName("proTier")
            val proTier: String?,
            @SerialName("profileCompleted")
            val profileCompleted: Boolean?,
            @SerialName("ratingsCount")
            val ratingsCount: Int?,
            @SerialName("reviewsCount")
            val reviewsCount: Int?,
            @SerialName("sfwFilterPreference")
            val sfwFilterPreference: String?,
            @SerialName("slug")
            val slug: String?,
            @SerialName("status")
            val status: String?,
            @SerialName("subscribedToNewsletter")
            val subscribedToNewsletter: Boolean?,
            @SerialName("title")
            val title: String?,
            @SerialName("updatedAt")
            val updatedAt: String?,
            @SerialName("waifuOrHusbando")
            val waifuOrHusbando: String?,
            @SerialName("website")
            val website: String?
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
                            val height: String?,
                            @SerialName("width")
                            val width: String?
                        )

                        @Serializable
                        data class Medium(
                            @SerialName("height")
                            val height: String?,
                            @SerialName("width")
                            val width: String?
                        )

                        @Serializable
                        data class Small(
                            @SerialName("height")
                            val height: String?,
                            @SerialName("width")
                            val width: String?
                        )

                        @Serializable
                        data class Tiny(
                            @SerialName("height")
                            val height: String?,
                            @SerialName("width")
                            val width: String?
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
                            val height: String?,
                            @SerialName("width")
                            val width: String?
                        )

                        @Serializable
                        data class Small(
                            @SerialName("height")
                            val height: String?,
                            @SerialName("width")
                            val width: String?
                        )

                        @Serializable
                        data class Tiny(
                            @SerialName("height")
                            val height: String?,
                            @SerialName("width")
                            val width: String?
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
            @SerialName("blocks")
            val blocks: Blocks?,
            @SerialName("categoryFavorites")
            val categoryFavorites: CategoryFavorites?,
            @SerialName("favorites")
            val favorites: Favorites?,
            @SerialName("followers")
            val followers: Followers?,
            @SerialName("following")
            val following: Following?,
            @SerialName("libraryEntries")
            val libraryEntries: LibraryEntries?,
            @SerialName("linkedAccounts")
            val linkedAccounts: LinkedAccounts?,
            @SerialName("notificationSettings")
            val notificationSettings: NotificationSettings?,
            @SerialName("oneSignalPlayers")
            val oneSignalPlayers: OneSignalPlayers?,
            @SerialName("pinnedPost")
            val pinnedPost: PinnedPost?,
            @SerialName("profileLinks")
            val profileLinks: ProfileLinks?,
            @SerialName("quotes")
            val quotes: Quotes?,
            @SerialName("reviews")
            val reviews: Reviews?,
            @SerialName("stats")
            val stats: Stats?,
            @SerialName("userRoles")
            val userRoles: UserRoles?,
            @SerialName("waifu")
            val waifu: Waifu?
        ) {
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
        val last: String?
    )

    @Serializable
    data class Meta(
        @SerialName("count")
        val count: Int?
    )
}