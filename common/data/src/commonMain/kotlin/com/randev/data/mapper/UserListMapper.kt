package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.UserListResponse
import com.randev.domain.model.AttributesUser
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.UserListModel
import com.randev.domain.model.UserModel

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
class UserListMapper: BaseMapper<UserListResponse, UserListModel>() {
    override fun map(value: UserListResponse): UserListModel {
        return UserListModel(
            data = value.data?.map {
                it.mapToModel()
            } ?: emptyList()
        )
    }
}

fun UserListResponse.Data?.mapToModel() = UserModel(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    attributes = AttributesUser(
        about = this?.attributes?.about.orEmpty(),
        avatar = if (this?.attributes?.avatar != null) {
            CoverImageModel(
                large = this.attributes.avatar.large.orEmpty(),
                original = this.attributes.avatar.original.orEmpty(),
                small = this.attributes.avatar.small.orEmpty(),
                tiny = this.attributes.avatar.tiny.orEmpty(),
            )
        } else null,
        commentsCount = this?.attributes?.commentsCount ?: 0,
        confirmed = this?.attributes?.confirmed ?: false,
        createdAt = this?.attributes?.createdAt.orEmpty(),
        email = this?.attributes?.email.orEmpty(),
        favoritesCount = this?.attributes?.favoritesCount ?: 0,
        followersCount = this?.attributes?.followersCount ?: 0,
        followingCount = this?.attributes?.followingCount ?: 0,
        name = this?.attributes?.name.orEmpty(),
        permissions = this?.attributes?.permissions.orEmpty(),
        postsCount = this?.attributes?.postsCount ?: 0,
        profileCompleted = this?.attributes?.profileCompleted ?: false,
        ratingsCount = this?.attributes?.ratingsCount ?: 0,
        reviewsCount = this?.attributes?.reviewsCount ?: 0,
        slug = this?.attributes?.slug.orEmpty(),
        status = this?.attributes?.status.orEmpty()
    ),
)