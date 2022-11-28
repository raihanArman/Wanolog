package com.randev.domain.di

import com.randev.domain.usecase.anime.GetAnimeAllUseCase
import com.randev.domain.usecase.anime.GetAnimeDetailUseCase
import com.randev.domain.usecase.anime.GetAnimePopularUseCase
import com.randev.domain.usecase.anime.GetAnimeSearchFilterUseCase
import com.randev.domain.usecase.anime.GetAnimeTopRatingUseCase
import com.randev.domain.usecase.anime.GetAnimeTopUpcomingUseCase
import com.randev.domain.usecase.anime.GetAnimeTrendingUseCase
import com.randev.domain.usecase.category.GetCategoryAllUseCase
import com.randev.domain.usecase.character.GetCharacterAllUseCase
import com.randev.domain.usecase.character.GetCharacterAnimeUseCase
import com.randev.domain.usecase.character.GetCharacterMangaUseCase
import com.randev.domain.usecase.manga.GetMangaAllUseCase
import com.randev.domain.usecase.manga.GetMangaDetailUseCase
import com.randev.domain.usecase.manga.GetMangaPopularUseCase
import com.randev.domain.usecase.manga.GetMangaSearchFilterUseCase
import com.randev.domain.usecase.manga.GetMangaTopRatingUseCase
import com.randev.domain.usecase.manga.GetMangaTopUpcomingUseCase
import com.randev.domain.usecase.manga.GetMangaTrendingUseCase
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val useCaseModule = module {
    single { GetAnimeAllUseCase(get()) }
    single { GetAnimeTrendingUseCase(get()) }
    single { GetAnimeTopUpcomingUseCase(get()) }
    single { GetAnimeTopRatingUseCase(get()) }
    single { GetAnimePopularUseCase(get()) }
    single { GetCategoryAllUseCase(get()) }
    single { GetMangaAllUseCase(get()) }
    single { GetMangaTrendingUseCase(get()) }
    single { GetMangaTopUpcomingUseCase(get()) }
    single { GetMangaTopRatingUseCase(get()) }
    single { GetMangaPopularUseCase(get()) }
    single { GetCharacterAllUseCase(get()) }
    single { GetAnimeSearchFilterUseCase(get()) }
    single { GetMangaSearchFilterUseCase(get()) }
    single { GetAnimeDetailUseCase(get()) }
    single { GetMangaDetailUseCase(get()) }
    single { GetCharacterMangaUseCase(get()) }
    single { GetCharacterAnimeUseCase(get()) }
}