package com.randev.data.response


import com.randev.core.arch.BaseModel
import com.randev.core.arch.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserListResponse(
    @SerialName("data")
    val `data`: List<Data?>?,
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
            @SerialName("about")
            val about: String? = null,
            @SerialName("aoPro")
            val aoPro: String? = null,
            @SerialName("avatar")
            val avatar: Avatar? = null,
            @SerialName("commentsCount")
            val commentsCount: Int? = null,
            @SerialName("confirmed")
            val confirmed: Boolean? = null,
            @SerialName("createdAt")
            val createdAt: String? = null,
            @SerialName("email")
            val email: String? = null,
            @SerialName("favoritesCount")
            val favoritesCount: Int? = null,
            @SerialName("feedCompleted")
            val feedCompleted: Boolean? = null,
            @SerialName("followersCount")
            val followersCount: Int? = null,
            @SerialName("followingCount")
            val followingCount: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("permissions")
            val permissions: String? = null,
            @SerialName("postsCount")
            val postsCount: Int? = null,
            @SerialName("profileCompleted")
            val profileCompleted: Boolean? = null,
            @SerialName("ratingSystem")
            val ratingSystem: String? = null,
            @SerialName("ratingsCount")
            val ratingsCount: Int? = null,
            @SerialName("reviewsCount")
            val reviewsCount: Int? = null,
            @SerialName("sfwFilter")
            val sfwFilter: Boolean? = null,
            @SerialName("sfwFilterPreference")
            val sfwFilterPreference: String? = null,
            @SerialName("shareToGlobal")
            val shareToGlobal: Boolean? = null,
            @SerialName("slug")
            val slug: String? = null,
            @SerialName("status")
            val status: String? = null,
            @SerialName("subscribedToNewsletter")
            val subscribedToNewsletter: Boolean? = null,
            @SerialName("theme")
            val theme: String? = null,
            @SerialName("timeZone")
            val timeZone: String? = null,
            @SerialName("title")
            val title: String? = null,
            @SerialName("titleLanguagePreference")
            val titleLanguagePreference: String? = null,
            @SerialName("updatedAt")
            val updatedAt: String? = null,
            @SerialName("waifuOrHusbando")
            val waifuOrHusbando: String? = null,
            @SerialName("website")
            val website: String? = null
        ) {
            @Serializable
            data class Avatar(
                @SerialName("large")
                val large: String?= null,
                @SerialName("medium")
                val medium: String?= null,
                @SerialName("meta")
                val meta: Meta?= null,
                @SerialName("original")
                val original: String?= null,
                @SerialName("small")
                val small: String?= null,
                @SerialName("tiny")
                val tiny: String?= null
            ) {
                @Serializable
                data class Meta(
                    @SerialName("dimensions")
                    val dimensions: Dimensions?= null
                ) {
                    @Serializable
                    data class Dimensions(
                        @SerialName("large")
                        val large: Large?= null,
                        @SerialName("medium")
                        val medium: Medium?= null,
                        @SerialName("small")
                        val small: Small?= null,
                        @SerialName("tiny")
                        val tiny: Tiny?= null
                    ) {
                        @Serializable
                        data class Large(
                            @SerialName("height")
                            val height: Int?= null,
                            @SerialName("width")
                            val width: Int?= null
                        )

                        @Serializable
                        data class Medium(
                            @SerialName("height")
                            val height: Int?= null,
                            @SerialName("width")
                            val width: Int?= null
                        )

                        @Serializable
                        data class Small(
                            @SerialName("height")
                            val height: Int?= null,
                            @SerialName("width")
                            val width: Int?= null
                        )

                        @Serializable
                        data class Tiny(
                            @SerialName("height")
                            val height: Int?= null,
                            @SerialName("width")
                            val width: Int?= null
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
}