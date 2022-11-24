package com.randev.wanolog.android.presentation.home

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.dashboard.anime.AnimeScreen
import com.randev.wanolog.android.presentation.dashboard.anime.AnimeViewModel
import com.randev.wanolog.android.presentation.home.component.CategorySection
import com.randev.wanolog.android.presentation.home.component.ContentTypeItem
import com.randev.wanolog.android.presentation.dashboard.manga.MangaScreen
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {

    val state by viewModel.observeCategory.collectAsState()
    val contentTypeSelected = viewModel.contentTypeState

    val drawerState = remember { mutableStateOf(DrawerValue.Closed) }


    LaunchedEffect(key1 = true) {
        viewModel.getCategory()
    }


    fun hideShowSidePanel() {
        if (drawerState.value == DrawerValue.Closed) {
            drawerState.value = DrawerValue.Open
        } else {
            drawerState.value = DrawerValue.Closed
        }

    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = MovieAppTheme.colors.colorPrimary
    ) {
        BoxWithConstraints {
            val parentWidth = this.maxWidth
            val parentHeight = this.maxHeight

            val mainContentAnimation = animateOffsetAsState(
                targetValue = Offset(
                    x = if (drawerState.value == DrawerValue.Open) {
                        -parentWidth.value / 2
                    } else {
                        0f
                    },
                    y = 0f
                ),
            )
            Box(
                modifier = Modifier.offset(
                    x = mainContentAnimation.value.x.dp,
                    y = mainContentAnimation.value.y.dp
                )
            ) {
                MainContent(
                    state = state,
                    contentTypeSelected = contentTypeSelected,
                    openSidePanel = {
                                    hideShowSidePanel()
                    },
                    onClickAnime = {
                        viewModel.changeContentType(ContentType.ANIME)
                    },
                    onClickManga = {
                        viewModel.changeContentType(ContentType.MANGA)
                    }
                )
            }

            state.categoryData?.let {
                if (drawerState.value == DrawerValue.Open) {
                    Box(
                        modifier = Modifier
                            .size(parentWidth / 2, height = parentHeight)
                            .offset(x = parentWidth / 2)
                    ) {
                        SidePanel(
                            categories = it
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    state: HomeState,
    contentTypeSelected: ContentType,
    openSidePanel: () -> Unit,
    onClickAnime: () -> Unit,
    onClickManga: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(
                top = 25.dp,
                start = 25.dp
            ),
    ) {
        state.categoryData?.let {
            CategorySection(
                data = it,
                openDrawer = openSidePanel
            )
        }
        VerticalSpacer(height = 25.dp)
//        Row {
//            ContentTypeItem(
//                contentTypeCurrent = ContentType.ANIME,
//                contentTypeSelected = contentTypeSelected,
//                onClick = onClickAnime
//            )
//            ContentTypeItem(
//                contentTypeCurrent = ContentType.MANGA,
//                contentTypeSelected = contentTypeSelected,
//                onClick = onClickManga
//            )
//        }
        if (contentTypeSelected == ContentType.ANIME) {
            AnimeScreen()
        } else {
            MangaScreen()
        }
    }
}
