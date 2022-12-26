package com.randev.data.di

import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeFavoriteMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.mapper.CategoryListMapper
import com.randev.data.mapper.CharacterByTypeListMapper
import com.randev.data.mapper.CharacterDetailMapper
import com.randev.data.mapper.CharacterListMapper
import com.randev.data.mapper.CommentListMapper
import com.randev.data.mapper.MangaDetailMapper
import com.randev.data.mapper.MangaFavoriteMapper
import com.randev.data.mapper.MangaListMapper
import com.randev.data.mapper.PostListMapper
import com.randev.data.mapper.QuoteFavoriteMapper
import com.randev.data.mapper.QuoteListMapper
import com.randev.data.mapper.ReviewListMapper
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
    single { PostListMapper() }
    single { CommentListMapper() }
    single { ReviewListMapper() }
    single { QuoteListMapper(get()) }
    single { AnimeFavoriteMapper() }
    single { MangaFavoriteMapper() }
    single { QuoteFavoriteMapper() }
}