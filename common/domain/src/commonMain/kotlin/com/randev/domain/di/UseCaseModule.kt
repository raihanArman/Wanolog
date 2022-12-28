package com.randev.domain.di

import com.randev.domain.usecase.anime.GetAnimeAllUseCase
import com.randev.domain.usecase.anime.GetAnimeByCategoryUseCase
import com.randev.domain.usecase.anime.GetAnimeDetailUseCase
import com.randev.domain.usecase.anime.GetAnimePopularUseCase
import com.randev.domain.usecase.anime.GetAnimeSearchFilterUseCase
import com.randev.domain.usecase.anime.GetAnimeTopRatingUseCase
import com.randev.domain.usecase.anime.GetAnimeTopUpcomingUseCase
import com.randev.domain.usecase.anime.GetAnimeTrendingUseCase
import com.randev.domain.usecase.anime_favorite.DeleteAnimeFavoriteUseCase
import com.randev.domain.usecase.anime_favorite.GetAnimeFavoriteUseCase
import com.randev.domain.usecase.anime_favorite.InsertAnimeFavoriteUseCase
import com.randev.domain.usecase.auth.CheckUserLoginUseCase
import com.randev.domain.usecase.auth.PostLoginUseCase
import com.randev.domain.usecase.category.GetCategoryAllUseCase
import com.randev.domain.usecase.character.GetCharacterAllUseCase
import com.randev.domain.usecase.character.GetCharacterAnimeUseCase
import com.randev.domain.usecase.character.GetCharacterDetailUseCase
import com.randev.domain.usecase.character.GetCharacterMangaUseCase
import com.randev.domain.usecase.comment.GetCommentsByPostUseCase
import com.randev.domain.usecase.manga.GetMangaAllUseCase
import com.randev.domain.usecase.manga.GetMangaByCategoryUseCase
import com.randev.domain.usecase.manga.GetMangaDetailUseCase
import com.randev.domain.usecase.manga.GetMangaPopularUseCase
import com.randev.domain.usecase.manga.GetMangaSearchFilterUseCase
import com.randev.domain.usecase.manga.GetMangaTopRatingUseCase
import com.randev.domain.usecase.manga.GetMangaTopUpcomingUseCase
import com.randev.domain.usecase.manga.GetMangaTrendingUseCase
import com.randev.domain.usecase.manga_favorite.DeleteMangaFavoriteUseCase
import com.randev.domain.usecase.manga_favorite.GetMangaFavoriteUseCase
import com.randev.domain.usecase.manga_favorite.InsertMangaFavoriteUseCase
import com.randev.domain.usecase.post.GetPostListUseCase
import com.randev.domain.usecase.quote_favorite.DeleteQuoteFavoriteUseCase
import com.randev.domain.usecase.quote_favorite.GetQuoteFavoriteUseCase
import com.randev.domain.usecase.quote_favorite.InsertQuoteFavoriteUseCase
import com.randev.domain.usecase.quote_favorite.IsQuoteFavoriteUseCase
import com.randev.domain.usecase.quotes.GetQuoteListUseCase
import com.randev.domain.usecase.review.GetAnimeReviewUseCase
import com.randev.domain.usecase.review.GetMangaReviewUseCase
import com.randev.domain.usecase.user.GetCurrentUserUseCase
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
    single { GetAnimeByCategoryUseCase(get()) }
    single { GetCategoryAllUseCase(get()) }
    single { GetMangaAllUseCase(get()) }
    single { GetMangaTrendingUseCase(get()) }
    single { GetMangaTopUpcomingUseCase(get()) }
    single { GetMangaTopRatingUseCase(get()) }
    single { GetMangaPopularUseCase(get()) }
    single { GetMangaByCategoryUseCase(get()) }
    single { GetCharacterAllUseCase(get()) }
    single { GetAnimeSearchFilterUseCase(get()) }
    single { GetMangaSearchFilterUseCase(get()) }
    single { GetAnimeDetailUseCase(get()) }
    single { GetMangaDetailUseCase(get()) }
    single { GetCharacterMangaUseCase(get()) }
    single { GetCharacterAnimeUseCase(get()) }
    single { GetCharacterDetailUseCase(get()) }
    single { PostLoginUseCase(get()) }
    single { CheckUserLoginUseCase(get()) }
    single { GetCurrentUserUseCase(get()) }
    single { GetPostListUseCase(get()) }
    single { GetCommentsByPostUseCase(get()) }
    single { GetAnimeReviewUseCase(get()) }
    single { GetMangaReviewUseCase(get()) }
    single { GetQuoteListUseCase(get()) }
    single { InsertAnimeFavoriteUseCase(get()) }
    single { DeleteAnimeFavoriteUseCase(get()) }
    single { InsertMangaFavoriteUseCase(get()) }
    single { DeleteMangaFavoriteUseCase(get()) }
    single { InsertQuoteFavoriteUseCase(get()) }
    single { DeleteQuoteFavoriteUseCase(get()) }
    single { IsQuoteFavoriteUseCase(get()) }
    single { GetAnimeFavoriteUseCase(get()) }
    single { GetMangaFavoriteUseCase(get()) }
    single { GetQuoteFavoriteUseCase(get()) }
}