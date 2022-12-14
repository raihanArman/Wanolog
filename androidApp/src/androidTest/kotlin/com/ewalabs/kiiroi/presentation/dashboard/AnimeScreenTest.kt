package com.ewalabs.kiiroi.presentation.dashboard

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import com.ewalabs.kiiroi.android.presentation.home.component.AnimeAllSection
import com.ewalabs.kiiroi.utils.DASHBOARD_ANIME_CONTENT_TAG
import com.ewalabs.kiiroi.data.fakeDataAnime
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
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
            KiiroiAppTheme {
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
            KiiroiAppTheme {
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
            KiiroiAppTheme {
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