package com.ewalabs.domain.di

import com.ewalabs.domain.usecase.anime.GetAnimeAllUseCase
import com.ewalabs.domain.usecase.anime.GetAnimeByCategoryUseCase
import com.ewalabs.domain.usecase.anime.GetAnimeDetailUseCase
import com.ewalabs.domain.usecase.anime.GetAnimePopularUseCase
import com.ewalabs.domain.usecase.anime.GetAnimeSearchFilterUseCase
import com.ewalabs.domain.usecase.anime.GetAnimeTopRatingUseCase
import com.ewalabs.domain.usecase.anime.GetAnimeTopUpcomingUseCase
import com.ewalabs.domain.usecase.anime.GetAnimeTrendingUseCase
import com.ewalabs.domain.usecase.anime_favorite.DeleteAnimeFavoriteUseCase
import com.ewalabs.domain.usecase.anime_favorite.GetAnimeFavoriteUseCase
import com.ewalabs.domain.usecase.anime_favorite.InsertAnimeFavoriteUseCase
import com.ewalabs.domain.usecase.auth.CheckUserLoginUseCase
import com.ewalabs.domain.usecase.auth.PostLoginUseCase
import com.ewalabs.domain.usecase.category.GetCategoryAllUseCase
import com.ewalabs.domain.usecase.character.GetCharacterAllUseCase
import com.ewalabs.domain.usecase.character.GetCharacterAnimeUseCase
import com.ewalabs.domain.usecase.character.GetCharacterDetailUseCase
import com.ewalabs.domain.usecase.character.GetCharacterMangaUseCase
import com.ewalabs.domain.usecase.comment.GetCommentsByPostUseCase
import com.ewalabs.domain.usecase.manga.GetMangaAllUseCase
import com.ewalabs.domain.usecase.manga.GetMangaByCategoryUseCase
import com.ewalabs.domain.usecase.manga.GetMangaDetailUseCase
import com.ewalabs.domain.usecase.manga.GetMangaPopularUseCase
import com.ewalabs.domain.usecase.manga.GetMangaSearchFilterUseCase
import com.ewalabs.domain.usecase.manga.GetMangaTopRatingUseCase
import com.ewalabs.domain.usecase.manga.GetMangaTopUpcomingUseCase
import com.ewalabs.domain.usecase.manga.GetMangaTrendingUseCase
import com.ewalabs.domain.usecase.manga_favorite.DeleteMangaFavoriteUseCase
import com.ewalabs.domain.usecase.manga_favorite.GetMangaFavoriteUseCase
import com.ewalabs.domain.usecase.manga_favorite.InsertMangaFavoriteUseCase
import com.ewalabs.domain.usecase.post.GetPostListUseCase
import com.ewalabs.domain.usecase.quote_favorite.DeleteQuoteFavoriteUseCase
import com.ewalabs.domain.usecase.quote_favorite.GetQuoteFavoriteUseCase
import com.ewalabs.domain.usecase.quote_favorite.InsertQuoteFavoriteUseCase
import com.ewalabs.domain.usecase.quote_favorite.IsQuoteFavoriteUseCase
import com.ewalabs.domain.usecase.quotes.GetQuoteListUseCase
import com.ewalabs.domain.usecase.review.GetAnimeReviewUseCase
import com.ewalabs.domain.usecase.review.GetMangaReviewUseCase
import com.ewalabs.domain.usecase.user.GetCurrentUserUseCase
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