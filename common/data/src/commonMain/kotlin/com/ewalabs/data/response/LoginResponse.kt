package com.ewalabs.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("access_token")
    val accessToken: String? = null,
    @SerialName("created_at")
    val createdAt: Int? = null,
    @SerialName("expires_in")
    val expiresIn: Int? = null,
    @SerialName("refresh_token")
    val refreshToken: String? = null,
    @SerialName("token_type")
    val tokenType: String? = null
)