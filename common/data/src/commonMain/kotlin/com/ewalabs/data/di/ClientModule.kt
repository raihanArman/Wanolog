package com.ewalabs.data.di

import com.ewalabs.data.datasource.remote.AnimeApi
import com.ewalabs.data.datasource.remote.AnimeApiClient
import com.ewalabs.data.datasource.remote.AuthApi
import com.ewalabs.data.datasource.remote.AuthApiClient
import com.ewalabs.data.datasource.remote.CategoryApi
import com.ewalabs.data.datasource.remote.CategoryApiClient
import com.ewalabs.data.datasource.remote.CharacterApi
import com.ewalabs.data.datasource.remote.CharactersApiClient
import com.ewalabs.data.datasource.remote.CommentApi
import com.ewalabs.data.datasource.remote.CommentApiClient
import com.ewalabs.data.datasource.remote.MangaApi
import com.ewalabs.data.datasource.remote.MangaApiClient
import com.ewalabs.data.datasource.remote.PostApi
import com.ewalabs.data.datasource.remote.PostApiClient
import com.ewalabs.data.datasource.remote.QuoteApi
import com.ewalabs.data.datasource.remote.QuoteApiClient
import com.ewalabs.data.datasource.remote.ReviewApi
import com.ewalabs.data.datasource.remote.ReviewApiClient
import com.ewalabs.data.datasource.remote.UserApi
import com.ewalabs.data.datasource.remote.UserApiClient
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