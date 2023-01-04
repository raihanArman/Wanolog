package com.ewalabs.core.arch

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

open class BaseResponse {
    @SerialName("links")
    val links: Links? = null
    @SerialName("meta")
    val meta: Meta? = null
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