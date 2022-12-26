package com.randev.data.di

import com.randev.data.repository.AnimeFavoriteRepositoryImpl
import com.randev.data.repository.AnimeRepositoryImpl
import com.randev.data.repository.AuthRepositoryImpl
import com.randev.data.repository.CategoryRepositoryImpl
import com.randev.data.repository.CharacterRepositoryImpl
import com.randev.data.repository.CommentRepositoryImpl
import com.randev.data.repository.MangaFavoriteRepositoryImpl
import com.randev.data.repository.MangaRepositoryImpl
import com.randev.data.repository.PostRepositoryImpl
import com.randev.data.repository.QuoteFavoriteRepositoryImpl
import com.randev.data.repository.QuoteRepositoryImpl
import com.randev.data.repository.ReviewRepositoryImpl
import com.randev.data.repository.UserRepositoryImpl
import com.randev.domain.repository.AnimeFavoriteRepository
import com.randev.domain.repository.AnimeRepository
import com.randev.domain.repository.AuthRepository
import com.randev.domain.repository.CategoryRepository
import com.randev.domain.repository.CharacterRepository
import com.randev.domain.repository.CommentRepository
import com.randev.domain.repository.MangaFavoriteRepository
import com.randev.domain.repository.MangaRepository
import com.randev.domain.repository.PostRepository
import com.randev.domain.repository.QuoteFavoriteRepository
import com.randev.domain.repository.QuoteRepository
import com.randev.domain.repository.ReviewRepository
import com.randev.domain.repository.UserRepository
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val repositoryModule = module {
    single<AnimeRepository> { AnimeRepositoryImpl(get(), get(), get(), get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get(), get()) }
    single<MangaRepository> { MangaRepositoryImpl(get(), get(), get(), get()) }
    single<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }
    single<AuthRepository> { AuthRepositoryImpl(get(), get(), get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<PostRepository> { PostRepositoryImpl(get(), get()) }
    single<CommentRepository> { CommentRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
    single<QuoteRepository> { QuoteRepositoryImpl(get(), get()) }
    single<AnimeFavoriteRepository> { AnimeFavoriteRepositoryImpl(get(), get()) }
    single<MangaFavoriteRepository> { MangaFavoriteRepositoryImpl(get(), get()) }
    single<QuoteFavoriteRepository> { QuoteFavoriteRepositoryImpl(get(), get()) }
}