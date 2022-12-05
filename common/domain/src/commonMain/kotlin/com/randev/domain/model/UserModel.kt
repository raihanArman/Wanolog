package com.randev.domain.model

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
data class UserModel(
    val attributes: AttributesUser,
    val id: String,
    val type: String
)

data class AttributesUser(
    val about: String,
    val avatar: CoverImageModel?,
    val commentsCount: Int,
    val confirmed: Boolean,
    val createdAt: String,
    val email: String,
    val favoritesCount: Int,
    val followersCount: Int,
    val followingCount: Int,
    val name: String,
    val permissions: String,
    val postsCount: Int,
    val profileCompleted: Boolean,
    val ratingsCount: Int,
    val reviewsCount: Int,
    val slug: String,
    val status: String,
)