package com.randev.wanolog.android.composable.components.text_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MovieAppTheme.colors.colorAccent,
            unfocusedBorderColor = MovieAppTheme.colors.colorAccent,
            cursorColor = MovieAppTheme.colors.colorAccent,
            textColor = Color.White
        ),
        leadingIcon = leadingIcon
    )
}