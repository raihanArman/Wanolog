package com.randev.data.repository

import com.randev.core.wrapper.Resource
import com.randev.data.datasource.local.AnimeFavoriteDataSource
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.response.AnimeListResponse
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


/**
 * @author Raihan Arman
 * @date 01/01/23
 */
@OptIn(ExperimentalCoroutinesApi::class)
class AnimeRepositoryTest {

    private lateinit var repository: AnimeRepository

    @MockK val api = mockk<AnimeApiClient>()
    @MockK val mapper = mockk<AnimeListMapper>()
    @MockK val detailMapper = mockk<AnimeDetailMapper>()
    @MockK val dataSource = mockk<AnimeFavoriteDataSource>()

    @BeforeTest
    fun setup() {
        repository = AnimeRepositoryImpl(
            api = api,
            mapper = mapper,
            mapperDetail = detailMapper,
            favoriteDataSource = dataSource
        )
    }

    @Test
    fun `Given fetch anime all should returns success`() {
        runTest {
            coEvery { mapper.map(AnimeListResponse(null)) } returns(
                    AnimeListModel(emptyList()).apply {
                        status = true
                    }
            )
            coEvery { api.fetchAnimeAll(1) } returns(AnimeListResponse(null))

            val actual = repository.getAnimeAll(1).last()
            val expected = Resource.Success(AnimeListModel(data = emptyList()))

            assertEquals(expected,actual)
        }
    }

    @Test
    fun `Given fetch anime all should returns error`() {
        runTest {
            coEvery { mapper.map(AnimeListResponse(null)) } returns(
                    AnimeListModel(emptyList()).apply {
                        status = false
                    }
            )
            coEvery { api.fetchAnimeAll(1) } returns(AnimeListResponse(null))

            val actual = repository.getAnimeAll(1).last()

            assertTrue(actual is Resource.Error)

        }
    }

//    @Test
//    fun `Given fetch anime trending should returns error`() {
//        runTest {
//            coEvery { mapper.map(AnimeListResponse(null)) } returns(
//                    AnimeListModel(emptyList()).apply {
//                        status = false
//                    }
//            )
//
//            coEvery { api. }
//
//        }
//    }


}