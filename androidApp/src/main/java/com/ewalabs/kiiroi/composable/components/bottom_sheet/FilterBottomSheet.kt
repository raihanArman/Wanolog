package com.ewalabs.kiiroi.composable.components.bottom_sheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.core.SortType
import com.ewalabs.core.listOfSort
import com.ewalabs.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme
import com.ewalabs.kiiroi.composable.components.button.PrimaryButton
import com.ewalabs.kiiroi.utils.SheetHandler

/**
 * @author Raihan Arman
 * @date 24/11/22
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterBottomDialog(
    modifier: Modifier = Modifier,
    onApply: (SortType) -> Unit,
    currentSelected: SortType,
    state: SheetHandler,
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(currentSelected) }
    ModalBottomSheetLayout(
        sheetState = state.handle(),
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        sheetContent = {
            Surface(
                modifier = modifier
                    .fillMaxWidth(),
                color = Color.Black,
            ) {
                Column(
                    modifier = Modifier
                        .padding(25.dp)
                ) {
                    Text(
                        text = "Sort",
                        style = MovieAppTheme.typography.bold,
                        color = Color.White,
                        fontSize = 24.sp
                    )
                    VerticalSpacer(height = 20.dp)
                    listOfSort().forEach { sortType ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (sortType == selectedOption),
                                    onClick = { onOptionSelected(sortType) }
                                )
                        ) {
                            Text(
                                text = sortType.value,
                                modifier = Modifier
                                    .weight(1f),
                                color = Color.White,
                                style = MovieAppTheme.typography.medium,
                                fontSize = 16.sp
                            )
                            RadioButton(
                                selected = (sortType == selectedOption),
                                onClick = {
                                    onOptionSelected(sortType)
                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MovieAppTheme.colors.colorAccent,
                                    unselectedColor = Color.White,
                                )
                            )
                        }
                    }
                    VerticalSpacer(height = 20.dp)
                    PrimaryButton(
                        text = "Apply",
                        onClick = {
                            onApply(selectedOption)

                        }
                    )
                }
            }
        }
    ) {

    }
}