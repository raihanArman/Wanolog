package com.ewalabs.data.di

import com.ewalabs.data.mapper.AnimeDetailMapper
import com.ewalabs.data.mapper.AnimeFavoriteMapper
import com.ewalabs.data.mapper.AnimeListMapper
import com.ewalabs.data.mapper.CategoryListMapper
import com.ewalabs.data.mapper.CharacterByTypeListMapper
import com.ewalabs.data.mapper.CharacterDetailMapper
import com.ewalabs.data.mapper.CharacterListMapper
import com.ewalabs.data.mapper.CommentListMapper
import com.ewalabs.data.mapper.MangaDetailMapper
import com.ewalabs.data.mapper.MangaFavoriteMapper
import com.ewalabs.data.mapper.MangaListMapper
import com.ewalabs.data.mapper.PostListMapper
import com.ewalabs.data.mapper.QuoteFavoriteMapper
import com.ewalabs.data.mapper.QuoteListMapper
import com.ewalabs.data.mapper.ReviewListMapper
import com.ewalabs.data.mapper.UserListMapper
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