package com.randev.kiiroi.android.presentation.character_manga

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CharacterListModel
import com.randev.domain.usecase.character.CharacterMangaRequest
import com.randev.domain.usecase.character.GetCharacterMangaUseCase
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class CharacterMangaPagingSource(
    private val useCase: GetCharacterMangaUseCase,
    private val id: String,
): PagingSource<Int, CharacterListModel.CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterListModel.CharacterModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterListModel.CharacterModel> {
        val currentPage = params.key ?: 0
        return when(val response = useCase.invoke(CharacterMangaRequest(page = currentPage, id = id)).last()) {
            is Resource.Success -> {
                val data = response.model?.data ?: emptyList()
                val endOfPaginationReached = data.isEmpty()
                if (data.isNotEmpty()) {
                    LoadResult.Page(
                        data = data,
                        prevKey = if (currentPage == 1) null else currentPage - 1,
                        nextKey = if (endOfPaginationReached) null else currentPage + 1
                    )
                } else {
                    LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                    )
                }
            }
            else -> {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        }
    }

}