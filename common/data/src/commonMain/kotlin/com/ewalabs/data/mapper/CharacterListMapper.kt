package com.ewalabs.data.mapper

import com.ewalabs.core.arch.BaseMapper
import com.ewalabs.data.response.CharacterListResponse
import com.ewalabs.domain.model.CharacterListModel
import com.ewalabs.domain.model.CoverImageModel
import com.ewalabs.domain.model.NamesModel

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
        ).apply {
            status = true
        }
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