package com.randev.wanolog.android.presentation.dashboard.profile

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.randev.domain.model.UserModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.R
import com.randev.wanolog.android.composable.components.button.PrimaryButton
import com.randev.wanolog.android.composable.components.text_field.TextFieldCustom
import com.randev.wanolog.android.presentation.dashboard.quote.components.ItemQuote
import com.randev.wanolog.android.presentation.home.component.ItemCard
import com.randev.wanolog.android.utils.FavoriteTabEnum
import com.randev.wanolog.android.utils.items
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = getViewModel()
) {

    val state by viewModel.observeProfileState.collectAsState()
    val selectedFavoriteTab = viewModel.selectedTabFavorite
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.checkIsLogin()
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is ProfileViewModel.UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = MovieAppTheme.colors.colorPrimary
    ) {
        if (!state.isLogin) {
            LoginFormScreen(
                onEmailChange = viewModel::setEmailValue,
                onPasswordChange = viewModel::setEmailPassword,
                emailValue = { viewModel.emailState },
                passwordValue = { viewModel.passwordState },
                onClickSignIn = viewModel::postLogin,
                isLoadingButton = { viewModel.isLoading }
            )
        } else {
            state.userModel?.let { 
                UserScreen(
                    userModel = it,
                    onChangeFavoriteTab = viewModel::onChangeFavoriteType,
                    favoriteTab = selectedFavoriteTab,
                    state = state
                )
            }
        }
    }
}

@Composable
fun UserScreen(
    userModel: UserModel,
    favoriteTab: FavoriteTabEnum,
    onChangeFavoriteTab: (FavoriteTabEnum) -> Unit,
    state: ProfileState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalSpacer(height = 25.dp)
        if (userModel.attributes.avatar == null) {
            BaseImageView(
                imageResourceId = R.drawable.photo_default,
                modifier = Modifier
                    .size(120.dp)
                    .clip(
                        CircleShape
                    )
            )
        } else {
            BaseImageView(
                url = userModel.attributes.avatar!!.original,
                modifier = Modifier
                    .size(120.dp)
                    .clip(
                        CircleShape
                    )
            )
        }
        VerticalSpacer(height = 10.dp)
        Text(
            text = userModel.attributes.name,
            color = Color.White,
            style = MovieAppTheme.typography.bold,
            fontSize = 20.sp
        )

        VerticalSpacer(height = 20.dp)
        
        FavoriteTab(onTabSelected = {
            onChangeFavoriteTab(it)
        }, selectedTab = favoriteTab)
        
        FavoriteBody(favoriteTab, state)
        
    }
}

@Composable
fun FavoriteBody(selectedTabIndex: FavoriteTabEnum, state: ProfileState) {
    when (selectedTabIndex) {
        FavoriteTabEnum.ANIME -> {
            state.favAnimeList?.let { fav ->
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(25.dp),
                    horizontalArrangement = Arrangement.spacedBy(25.dp),
                    verticalArrangement = Arrangement.spacedBy(25.dp),
                    columns = GridCells.Fixed(2)
                ) {
                    items(fav) { data ->
                        println("Data Favorite -> $data")
                        ItemCard(
                            title = data.title,
                            image = data.poster,
                            onClick = {},
                            id = data.id.toString(),
                            rating = data.rate.toString()
                        )
                    }
                }
            }
        }
        FavoriteTabEnum.MANGA -> {
            state.favMangaList?.let { fav ->
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(25.dp),
                    horizontalArrangement = Arrangement.spacedBy(25.dp),
                    verticalArrangement = Arrangement.spacedBy(25.dp),
                    columns = GridCells.Fixed(2)
                ) {
                    items(fav) { data ->
                        ItemCard(
                            title = data.title,
                            image = data.poster,
                            onClick = {},
                            id = data.id.toString(),
                            rating = data.rate.toString()
                        )
                    }
                }
            }
        }
        FavoriteTabEnum.QUOTE -> {
            state.favQuoteList?.let { fav ->
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(25.dp),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ){
                    items(fav) { quote ->
                        ItemQuote(
                            quote = quote.quote,
                            anime = quote.anime,
                            backgroundColor = quote.backgroundColor,
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FavoriteTab(
    modifier: Modifier = Modifier,
    onTabSelected: (FavoriteTabEnum) -> Unit,
    selectedTab: FavoriteTabEnum
) {
    val inactiveColor = Color(0xFF919191)
    val pagerState = rememberPagerState(pageCount = 3)
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = 0,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        indicator = { tabPositions ->
            // on below line we are specifying the styling
            // for tab indicator by specifying height
            // and color for the tab indicator.
            TabRowDefaults.Indicator(
                Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        },
        modifier = modifier
    ) {
        FavoriteTabEnum.values().forEachIndexed { index, favoriteTabEnum ->
            Tab(
                selected = selectedTab == favoriteTabEnum,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    onTabSelected(favoriteTabEnum)
                    scope.launch {
                        pagerState.animateScrollToPage(index, animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessLow)
                        )
                    }
                },
            ) {
                Icon(
                    painter = painterResource(id = favoriteTabEnum.icon),
                    contentDescription = null,
                    tint = if(selectedTab == favoriteTabEnum) Color.White else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }

}

@Composable
fun LoginFormScreen(
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    emailValue: () -> String,
    passwordValue: () -> String,
    onClickSignIn: () -> Unit,
    isLoadingButton: () -> Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        VerticalSpacer(height = 80.dp)
        Text(
            text = "Login with Kitsu.io Account",
            color = Color.White,
            style = MovieAppTheme.typography.bold,
            fontSize = 20.sp
        )
        VerticalSpacer(height = 80.dp)
        TextFieldCustom(
            value = emailValue.invoke(),
            onValueChange = onEmailChange,
            textHint = "Email"
        )
        VerticalSpacer(height = 10.dp)
        TextFieldCustom(
            value = passwordValue.invoke(),
            onValueChange = onPasswordChange,
            isPasswordTextFieldProvider = { true },
            textHint = "Password"
        )
        VerticalSpacer(height = 20.dp)
        PrimaryButton(
            text = "Sign In",
            onClick = onClickSignIn,
            isLoading = isLoadingButton
        )
        VerticalSpacer(height = 40.dp)
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(Color.White)){
                    append("Don't have an account? ")
                }
                withStyle(style = SpanStyle(MovieAppTheme.colors.colorAccent)){
                    append(" Sign Up with Kitsu.IO")
                }
            },
            fontSize = 14.sp,
            fontFamily = MaterialTheme.typography.subtitle1.fontFamily
        )
    }
}