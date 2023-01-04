package com.ewalabs.data.di

import com.ewalabs.data.repository.AnimeFavoriteRepositoryImpl
import com.ewalabs.data.repository.AnimeRepositoryImpl
import com.ewalabs.data.repository.AuthRepositoryImpl
import com.ewalabs.data.repository.CategoryRepositoryImpl
import com.ewalabs.data.repository.CharacterRepositoryImpl
import com.ewalabs.data.repository.CommentRepositoryImpl
import com.ewalabs.data.repository.MangaFavoriteRepositoryImpl
import com.ewalabs.data.repository.MangaRepositoryImpl
import com.ewalabs.data.repository.PostRepositoryImpl
import com.ewalabs.data.repository.QuoteFavoriteRepositoryImpl
import com.ewalabs.data.repository.QuoteRepositoryImpl
import com.ewalabs.data.repository.ReviewRepositoryImpl
import com.ewalabs.data.repository.UserRepositoryImpl
import com.ewalabs.domain.repository.AnimeFavoriteRepository
import com.ewalabs.domain.repository.AnimeRepository
import com.ewalabs.domain.repository.AuthRepository
import com.ewalabs.domain.repository.CategoryRepository
import com.ewalabs.domain.repository.CharacterRepository
import com.ewalabs.domain.repository.CommentRepository
import com.ewalabs.domain.repository.MangaFavoriteRepository
import com.ewalabs.domain.repository.MangaRepository
import com.ewalabs.domain.repository.PostRepository
import com.ewalabs.domain.repository.QuoteFavoriteRepository
import com.ewalabs.domain.repository.QuoteRepository
import com.ewalabs.domain.repository.ReviewRepository
import com.ewalabs.domain.repository.UserRepository
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