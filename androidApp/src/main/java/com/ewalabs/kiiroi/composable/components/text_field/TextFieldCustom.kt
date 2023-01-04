package com.ewalabs.kiiroi.composable.components.text_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.R

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    value: String,
    textHint: String? = null,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordTextFieldProvider: () -> Boolean = { false },
) {
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = KiiroiAppTheme.colors.colorAccent,
            unfocusedBorderColor = KiiroiAppTheme.colors.colorAccent,
            cursorColor = KiiroiAppTheme.colors.colorAccent,
            textColor = Color.White
        ),
        leadingIcon = leadingIcon,
        trailingIcon = if(trailingIcon != null) trailingIcon else{
            {
                if(isPasswordTextFieldProvider()) {
                    IconButton(
                        onClick = {
                            isPasswordVisible.value = !isPasswordVisible.value
                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(
                                id = if (isPasswordVisible.value) {
                                    R.drawable.ic_show_password
                                } else {
                                    R.drawable.ic_hide_password
                                }
                            ),
                            tint = KiiroiAppTheme.colors.colorAccent,
                            contentDescription = null
                        )
                    }
                }
            }
        },
        visualTransformation = if(isPasswordTextFieldProvider()){
            if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        placeholder = {
            if (textHint != null) {
                Text(
                    text = textHint,
                    style = KiiroiAppTheme.typography.light,
                    color = Color.White.copy(alpha = 0.3f)
                )
            }
        }
    )
}