package com.randev.kiiroi.presentation.dashboard

import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import com.randev.kiiroi.android.presentation.anime_all.AnimeAllScreen
import com.randev.kiiroi.android.presentation.dashboard.anime.AnimeScreen
import com.randev.kiiroi.android.presentation.home.component.AnimeAllSection
import com.randev.kiiroi.android.utils.DASHBOARD_ANIME_CONTENT_TAG
import com.randev.kiiroi.data.fakeDataAnime
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import org.junit.Rule
import org.junit.Test

/**
 * @author Raihan Arman
 * @date 02/01/23
 */
class AnimeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAnimeIfDataIsEmpty() {
        composeTestRule.setContent {
            MovieAppTheme {
                AnimeAllSection(
                    data = emptyList(),
                    onClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(DASHBOARD_ANIME_CONTENT_TAG)
            .onChildren()
            .assertCountEquals(0)
    }

    @Test
    fun testAnimeIdDataIsExist() {
        composeTestRule.setContent {
            MovieAppTheme {
                AnimeAllSection(
                    data = fakeDataAnime(),
                    onClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(DASHBOARD_ANIME_CONTENT_TAG)
            .onChildren()
            .assertCountEquals(2)
    }

    @Test
    fun testCompareAnimeContent() {
        composeTestRule.setContent {
            MovieAppTheme {
                AnimeAllSection(
                    data = fakeDataAnime(),
                    onClick = {}
                )
            }
        }

        composeTestRule.apply {
            onNodeWithTag(DASHBOARD_ANIME_CONTENT_TAG)
                .onChildren()
                .onFirst()
                .assert(hasText("Naruto"))
            onNodeWithTag(DASHBOARD_ANIME_CONTENT_TAG)
                .onChildren()
                .onFirst()
                .assert(hasText("86"))
        }
    }

}