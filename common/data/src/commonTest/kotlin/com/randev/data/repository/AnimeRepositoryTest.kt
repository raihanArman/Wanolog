package com.randev.data.repository

import com.randev.core.wrapper.Resource
import com.randev.data.datasource.local.AnimeFavoriteDataSource
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.di.clientModule
import com.randev.data.di.dataSourceModule
import com.randev.data.di.mapperModule
import com.randev.data.di.persistanceModule
import com.randev.data.di.repositoryModule
import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.response.AnimeListResponse
import com.randev.database.databaseModule
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import org.koin.test.mock.MockProvider
import org.koin.test.mock.declareMock
import kotlin.test.assertEquals


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
            coEvery { mapper.map(AnimeListResponse(null)) } returns(AnimeListModel(emptyList()))
            coEvery { api.fetchAnimeAll(1) } returns(AnimeListResponse(null))

            val actual = repository.getAnimeAll(1).last()
            val expected = Resource.Success(AnimeListModel(data = emptyList()))

            assertEquals(expected,actual)
        }
    }



}