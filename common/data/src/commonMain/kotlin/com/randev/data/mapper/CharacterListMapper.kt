package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.data.response.CharacterListResponse
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CharacterListModel
import com.randev.domain.model.CoverImageModel
import com.randev.domain.model.NamesModel

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class CharacterListMapper: BaseMapper<CharacterListResponse, CharacterListModel>() {
    override fun map(value: CharacterListResponse): CharacterListModel {
        return CharacterListModel(
            data = value.data?.map {
                it.mapToModel()
            } ?: emptyList()
        )
    }
}

fun CharacterListResponse.Data?.mapToModel() = CharacterListModel.CharacterModel(
    id = this?.id.orEmpty(),
    type = this?.type.orEmpty(),
    attributes = CharacterListModel.AttributesModel(
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