package com.ewalabs.data.response


import com.ewalabs.core.arch.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MangaListResponse(
    @SerialName("data")
    val data: List<Data?>? = null
): BaseResponse() {
    @Serializable
    data class Data(
        @SerialName("attributes")
        val attributes: Attributes?,
        @SerialName("id")
        val id: String?,
        @SerialName("type")
        val type: String?
    ) {
        @Serializable
        data class Attributes(
            @SerialName("abbreviatedTitles")
            val abbreviatedTitles: List<String?>?,
            @SerialName("ageRating")
            val ageRating: String?,
            @SerialName("ageRatingGuide")
            val ageRatingGuide: String?,
            @SerialName("averageRating")
            val averageRating: String?,
            @SerialName("canonicalTitle")
            val canonicalTitle: String?,
            @SerialName("chapterCount")
            val chapterCount: Int?,
            @SerialName("coverImage")
            val coverImage: CoverImage?,
            @SerialName("coverImageTopOffset")
            val coverImageTopOffset: Int?,
            @SerialName("createdAt")
            val createdAt: String?,
            @SerialName("description")
            val description: String?,
            @SerialName("endDate")
            val endDate: String?,
            @SerialName("favoritesCount")
            val favoritesCount: Int?,
            @SerialName("mangaType")
            val mangaType: String?,
            @SerialName("popularityRank")
            val popularityRank: Int?,
            @SerialName("posterImage")
            val posterImage: PosterImage?,
            @SerialName("ratingRank")
            val ratingRank: Int?,
            @SerialName("serialization")
            val serialization: String?,
            @SerialName("slug")
            val slug: String?,
            @SerialName("startDate")
            val startDate: String?,
            @SerialName("status")
            val status: String?,
            @SerialName("subtype")
            val subtype: String?,
            @SerialName("synopsis")
            val synopsis: String?,
            @SerialName("titles")
            val titles: Titles?,
            @SerialName("updatedAt")
            val updatedAt: String?,
            @SerialName("userCount")
            val userCount: Int?,
            @SerialName("volumeCount")
            val volumeCount: Int?
        ) {
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

            @Serializable
            data class PosterImage(
                @SerialName("large")
                val large: String? = null,
                @SerialName("medium")
                val medium: String? = null,
                @SerialName("meta")
                val meta: Meta? = null,
                @SerialName("original")
                val original: String? = null,
                @SerialName("small")
                val small: String? = null,
                @SerialName("tiny")
                val tiny: String? = null
            ) {
                @Serializable
                data class Meta(
                    @SerialName("dimensions")
                    val dimensions: Dimensions? = null
                ) {
                    @Serializable
                    data class Dimensions(
                        @SerialName("large")
                        val large: Large? = null,
                        @SerialName("medium")
                        val medium: Medium? = null,
                        @SerialName("small")
                        val small: Small? = null,
                        @SerialName("tiny")
                        val tiny: Tiny? = null
                    ) {
                        @Serializable
                        data class Large(
                            @SerialName("height")
                            val height: Int? = null,
                            @SerialName("width")
                            val width: Int? = null
                        )

                        @Serializable
                        data class Medium(
                            @SerialName("height")
                            val height: Int? = null,
                            @SerialName("width")
                            val width: Int? = null
                        )

                        @Serializable
                        data class Small(
                            @SerialName("height")
                            val height: Int? = null,
                            @SerialName("width")
                            val width: Int? = null
                        )

                        @Serializable
                        data class Tiny(
                            @SerialName("height")
                            val height: Int? = null,
                            @SerialName("width")
                            val width: Int? = null
                        )
                    }
                }
            }

            @Serializable
            data class Titles(
                @SerialName("ar")
                val ar: String? = null,
                @SerialName("en")
                val en: String? = null,
                @SerialName("en_jp")
                val enJp: String? = null,
                @SerialName("en_us")
                val enUs: String? = null,
                @SerialName("he_il")
                val heIl: String? = null,
                @SerialName("ja_jp")
                val jaJp: String? = null,
                @SerialName("ko_kr")
                val koKr: String? = null,
                @SerialName("lt_lt")
                val ltLt: String? = null,
                @SerialName("pl_pl")
                val plPl: String? = null,
                @SerialName("ru_ru")
                val ruRu: String? = null,
                @SerialName("th_th")
                val thTh: String? = null,
                @SerialName("tr_tr")
                val trTr: String? = null,
                @SerialName("vi_vn")
                val viVn: String? = null,
                @SerialName("zh_cn")
                val zhCn: String? = null,
                @SerialName("zh_tw")
                val zhTw: String? = null
            )
        }

    }
}