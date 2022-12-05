package com.randev.data.di

import com.randev.data.datasource.remote.AnimeApi
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.datasource.remote.AuthApi
import com.randev.data.datasource.remote.AuthApiClient
import com.randev.data.datasource.remote.CategoryApi
import com.randev.data.datasource.remote.CategoryApiClient
import com.randev.data.datasource.remote.CharacterApi
import com.randev.data.datasource.remote.CharactersApiClient
import com.randev.data.datasource.remote.MangaApi
import com.randev.data.datasource.remote.MangaApiClient
import com.randev.data.datasource.remote.UserApi
import com.randev.data.datasource.remote.UserApiClient
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val clientModule = module {
    single<AnimeApiClient> { AnimeApi(get()) }
    single<CategoryApiClient> { CategoryApi(get()) }
    single<MangaApiClient> { MangaApi(get()) }
    single<CharactersApiClient> { CharacterApi(get()) }
    single<AuthApiClient> { AuthApi(get()) }
    single<UserApiClient> { UserApi(get()) }
}