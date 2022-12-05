package com.randev.wanolog.android.presentation.dashboard.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.composable.components.button.PrimaryButton
import com.randev.wanolog.android.composable.components.text_field.TextFieldCustom
import kotlinx.coroutines.flow.collectLatest
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
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
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