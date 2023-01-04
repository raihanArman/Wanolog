package com.ewalabs.kiiroi.presentation.dashboard

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.ewalabs.kiiroi.presentation.dashboard.anime.AnimeScreen
import com.ewalabs.kiiroi.utils.ITEM_CARD_TAG
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme
import org.junit.Rule
import org.junit.Test

/**
 * @author Raihan Arman
 * @date 02/01/23
 */
class DetailAnimeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCompareWithDetailContent() {
        composeTestRule.setContent {
            MovieAppTheme {
                AnimeScreen()
//                AnimeAllSection(
//                    data = fakeDataAnime(),
//                    onClick = {
//
//                    }
//                )
            }
        }

        composeTestRule.onNodeWithTag(ITEM_CARD_TAG)
            .performClick()

    }


}