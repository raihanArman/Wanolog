package com.randev.data.di

import com.randev.data.datasource.remote.AnimeApi
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.datasource.remote.AuthApi
import com.randev.data.datasource.remote.AuthApiClient
import com.randev.data.datasource.remote.CategoryApi
import com.randev.data.datasource.remote.CategoryApiClient
import com.randev.data.datasource.remote.CharacterApi
import com.randev.data.datasource.remote.CharactersApiClient
import com.randev.data.datasource.remote.CommentApi
import com.randev.data.datasource.remote.CommentApiClient
import com.randev.data.datasource.remote.MangaApi
import com.randev.data.datasource.remote.MangaApiClient
import com.randev.data.datasource.remote.PostApi
import com.randev.data.datasource.remote.PostApiClient
import com.randev.data.datasource.remote.QuoteApi
import com.randev.data.datasource.remote.QuoteApiClient
import com.randev.data.datasource.remote.ReviewApi
import com.randev.data.datasource.remote.ReviewApiClient
import com.randev.data.datasource.remote.UserApi
import com.randev.data.datasource.remote.UserApiClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val clientModule = module {
    single<AnimeApiClient> { AnimeApi(get(named("kitsu"))) }
    single<CategoryApiClient> { CategoryApi(get(named("kitsu"))) }
    single<MangaApiClient> { MangaApi(get(named("kitsu"))) }
    single<CharactersApiClient> { CharacterApi(get(named("kitsu"))) }
    single<AuthApiClient> { AuthApi(get(named("kitsu"))) }
    single<UserApiClient> { UserApi(get(named("kitsu"))) }
    single<PostApiClient> { PostApi(get(named("kitsu"))) }
    single<CommentApiClient> { CommentApi(get(named("kitsu"))) }
    single<ReviewApiClient> { ReviewApi(get(named("kitsu"))) }
    single<QuoteApiClient> { QuoteApi(get(named("animechan"))) }
}