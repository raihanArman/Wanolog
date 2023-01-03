package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.CharacterByTypeListResponse
import com.randev.data.response.CharacterDetailResponse
import com.randev.domain.model.CharacterDetailModel
import com.randev.domain.model.CharacterListModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.NamesModel

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
class CharacterDetailMapper: BaseMapper<CharacterDetailResponse, CharacterDetailModel>() {
    override fun map(value: CharacterDetailResponse): CharacterDetailModel {
        val voices = value.included?.filter {
            it?.type == "people"
        }?.map {
            it.mapToVoice()
        } ?: emptyList()
        return CharacterDetailModel(
            data = value.data.mapToModel(),
            voices = voices
        ).apply {
            status = true
        }
    }
}

fun CharacterDetailResponse.Data?.mapToModel() = CharacterDetailModel.CharacterModel(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    attributes = CharacterDetailModel.AttributesModel(
        canonicalName = this?.attributes?.canonicalName.orEmpty(),
        createdAt = this?.attributes?.createdAt.orEmpty(),
        description = this?.attributes?.description.orEmpty(),
        image = CoverImageModel(
            large = this?.attributes?.image?.large.orEmpty(),
            original = this?.attributes?.image?.original.orEmpty(),
            small = this?.attributes?.image?.small.orEmpty(),
            tiny = this?.attributes?.image?.tiny.orEmpty(),
        ),
        malId = this?.attributes?.malId ?: 0,
        name = this?.attributes?.name.orEmpty(),
        names = NamesModel(
            en = this?.attributes?.names?.en.orEmpty(),
            jaJp = this?.attributes?.names?.jaJp.orEmpty(),
        ),
        otherNames = this?.attributes?.otherNames ?: emptyList(),
        slug = this?.attributes?.slug.orEmpty(),
        updatedAt = this?.attributes?.updatedAt.orEmpty()
    )
)

fun CharacterDetailResponse.Included?.mapToVoice() = CharacterDetailModel.Voices(
    id = this?.id.orEmpty(),
    name = this?.attributes?.name.orEmpty(),
    description = this?.attributes?.description.orEmpty(),
    image = CoverImageModel(
        large = this?.attributes?.image?.large.orEmpty(),
        original = this?.attributes?.image?.original.orEmpty(),
        small = this?.attributes?.image?.small.orEmpty(),
        tiny = this?.attributes?.image?.tiny.orEmpty(),
    ),
)