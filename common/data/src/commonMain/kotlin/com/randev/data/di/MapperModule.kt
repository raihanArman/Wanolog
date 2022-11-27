package com.randev.data.di

import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.mapper.CategoryListMapper
import com.randev.data.mapper.CharacterListMapper
import com.randev.data.mapper.MangaDetailMapper
import com.randev.data.mapper.MangaListMapper
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val mapperModule = module {
    single { AnimeListMapper() }
    single { CategoryListMapper() }
    single { MangaListMapper() }
    single { CharacterListMapper() }
    single { AnimeDetailMapper() }
    single { MangaDetailMapper() }
}