package com.ewalabs.kiiroi.presentation.dashboard.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ewalabs.kiiroi.R
import com.ewalabs.kiiroi.presentation.dashboard.DashboardBottomBarItem
import com.ewalabs.kiiroi.presentation.dashboard.DashboardBottomBarItemType
import com.ewalabs.kiiroi.utils.Screen

/**
 * @author Raihan Arman
 * @date 01/02/23
 */

val destinationList = listOf(
    DashboardBottomBarItem(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_home_24),
                contentDescription = null,
                modifier = androidx.compose.ui.Modifier
                    .size(24.dp),
            )
        },
        type = DashboardBottomBarItemType.POST,
        label = "Home",
        route = Screen.Post.route
    ),
    DashboardBottomBarItem(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_ondemand_video_24),
                contentDescription = null,
                modifier = androidx.compose.ui.Modifier
                    .size(24.dp),
            )
        },
        type = DashboardBottomBarItemType.ANIME,
        label = "Anime",
        route = Screen.Anime.route
    ),
    DashboardBottomBarItem(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                contentDescription = null,
                modifier = androidx.compose.ui.Modifier
                    .size(24.dp),
            )
        },
        type = DashboardBottomBarItemType.MANGA,
        label = "Manga",
        route = Screen.Manga.route
    ),
    DashboardBottomBarItem(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                contentDescription = null,
                modifier = androidx.compose.ui.Modifier
                    .size(24.dp),
            )
        },
        type = DashboardBottomBarItemType.FAVORITE,
        label = "Quote",
        route = Screen.Quote.route
    ),
    DashboardBottomBarItem(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_person_24),
                contentDescription = null,
                modifier = androidx.compose.ui.Modifier
                    .size(24.dp),
            )
        },
        type = DashboardBottomBarItemType.ACCOUNT,
        label = "Account",
        route = Screen.Account.route
    ),
)