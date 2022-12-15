package com.randev.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteListResponseItem(
    @SerialName("anime")
    val anime: String?,
    @SerialName("character")
    val character: String?,
    @SerialName("quote")
    val quote: String?
)