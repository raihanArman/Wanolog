package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 07/12/22
 */

data class EmbedModel(
    val description: String,
    val image: Image,
    val kind: String,
    val site: Site,
    val title: String,
    val url: String,
    val video: Video
): BaseModel() {
    data class Image(
        val height: Int,
        val url: String,
        val width: Int
    )

    data class Site(
        val name: String,
        val url: String
    )

    data class Video(
        val height: String,
        val type: String,
        val url: String,
        val width: String
    )
}
