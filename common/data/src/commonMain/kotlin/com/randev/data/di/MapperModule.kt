package com.randev.data.di

import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.mapper.CategoryListMapper
import com.randev.data.mapper.CharacterByTypeListMapper
import com.randev.data.mapper.CharacterDetailMapper
import com.randev.data.mapper.CharacterListMapper
import com.randev.data.mapper.MangaDetailMapper
import com.randev.data.mapper.MangaListMapper
import com.randev.data.mapper.UserListMapper
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
    single { CharacterByTypeListMapper() }
    single { CharacterDetailMapper() }
    single { UserListMapper() }
}