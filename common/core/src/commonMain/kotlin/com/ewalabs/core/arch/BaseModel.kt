package com.ewalabs.core.arch

import kotlinx.serialization.Serializable

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

open class BaseModel {
    val links: LinksModel = LinksModel()
    val meta: MetaModel = MetaModel()
    var status: Boolean = false
}

data class LinksModel(
    val first: String = "",
    val last: String = "",
    val next: String = ""
)

@Serializable
data class MetaModel(
    val count: Int = 0
)