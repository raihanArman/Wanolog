package com.ewalabs.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommentListResponse(
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
            @SerialName("likesCount")
            val likesCount: Int?,
            @SerialName("repliesCount")
            val repliesCount: Int?,
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
            @SerialName("likes")
            val likes: Likes? = null,
            @SerialName("parent")
            val parent: Parent? = null,
            @SerialName("post")
            val post: Post? = null,
            @SerialName("uploads")
            val uploads: Uploads? = null,
            @SerialName("user")
            val user: User? = null
        ) {
            @Serializable
            data class Likes(
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
            data class Parent(
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
            data class Replies(
                @SerialName("data")
                val `data`: List<String?>?,
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
            val about: String? = null,
            @SerialName("avatar")
            val avatar: Avatar? = null,
            @SerialName("birthday")
            val birthday: String? = null,
            @SerialName("blocked")
            val blocked: Boolean? = null,
            @SerialName("commentsCount")
            val commentsCount: Int? = null,
            @SerialName("content")
            val content: String? = null,
            @SerialName("contentFormatted")
            val contentFormatted: String? = null,
            @SerialName("coverImage")
            val coverImage: CoverImage? = null,
            @SerialName("createdAt")
            val createdAt: String? = null,
            @SerialName("deletedAt")
            val deletedAt: String? = null,
            @SerialName("editedAt")
            val editedAt: String? = null,
            @SerialName("embed")
            val embed: Data.Attributes.Embed? = null,
            @SerialName("embedUrl")
            val embedUrl: String? = null,
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
            @SerialName("lockedAt")
            val lockedAt: String? = null,
            @SerialName("lockedReason")
            val lockedReason: String? = null,
            @SerialName("mediaReactionsCount")
            val mediaReactionsCount: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("nsfw")
            val nsfw: Boolean? = null,
            @SerialName("pastNames")
            val pastNames: List<String?>? = null,
            @SerialName("permissions")
            val permissions: String? = null,
            @SerialName("postLikesCount")
            val postLikesCount: Int? = null,
            @SerialName("postsCount")
            val postsCount: Int? = null,
            @SerialName("proExpiresAt")
            val proExpiresAt: String? = null,
            @SerialName("proTier")
            val proTier: String? = null,
            @SerialName("profileCompleted")
            val profileCompleted: Boolean? = null,
            @SerialName("ratingsCount")
            val ratingsCount: Int? = null,
            @SerialName("reviewsCount")
            val reviewsCount: Int? = null,
            @SerialName("sfwFilterPreference")
            val sfwFilterPreference: String? = null,
            @SerialName("slug")
            val slug: String? = null,
            @SerialName("spoiler")
            val spoiler: Boolean? = null,
            @SerialName("status")
            val status: String? = null,
            @SerialName("subscribedToNewsletter")
            val subscribedToNewsletter: Boolean? = null,
            @SerialName("targetInterest")
            val targetInterest: String? = null,
            @SerialName("title")
            val title: String? = null,
            @SerialName("topLevelCommentsCount")
            val topLevelCommentsCount: Int? = null,
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
        }

        @Serializable
        data class Links(
            @SerialName("self")
            val self: String?
        )

        @Serializable
        data class Relationships(
            @SerialName("ama")
            val ama: Ama? = null,
            @SerialName("blocks")
            val blocks: Blocks? = null,
            @SerialName("categoryFavorites")
            val categoryFavorites: CategoryFavorites? = null,
            @SerialName("comments")
            val comments: Comments? = null,
            @SerialName("favorites")
            val favorites: Favorites? = null,
            @SerialName("followers")
            val followers: Followers? = null,
            @SerialName("following")
            val following: Following? = null,
            @SerialName("libraryEntries")
            val libraryEntries: LibraryEntries? = null,
            @SerialName("linkedAccounts")
            val linkedAccounts: LinkedAccounts? = null,
            @SerialName("lockedBy")
            val lockedBy: LockedBy? = null,
            @SerialName("media")
            val media: Media? = null,
            @SerialName("notificationSettings")
            val notificationSettings: NotificationSettings? = null,
            @SerialName("oneSignalPlayers")
            val oneSignalPlayers: OneSignalPlayers? = null,
            @SerialName("pinnedPost")
            val pinnedPost: PinnedPost? = null,
            @SerialName("postLikes")
            val postLikes: PostLikes? = null,
            @SerialName("profileLinks")
            val profileLinks: ProfileLinks? = null,
            @SerialName("quotes")
            val quotes: Quotes? = null,
            @SerialName("reviews")
            val reviews: Reviews? = null,
            @SerialName("spoiledUnit")
            val spoiledUnit: SpoiledUnit? = null,
            @SerialName("stats")
            val stats: Stats? = null,
            @SerialName("targetGroup")
            val targetGroup: TargetGroup? = null,
            @SerialName("targetUser")
            val targetUser: TargetUser? = null,
            @SerialName("uploads")
            val uploads: Uploads? = null,
            @SerialName("user")
            val user: User? = null,
            @SerialName("userRoles")
            val userRoles: UserRoles? = null,
            @SerialName("waifu")
            val waifu: Waifu? = null
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
            data class PostLikes(
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