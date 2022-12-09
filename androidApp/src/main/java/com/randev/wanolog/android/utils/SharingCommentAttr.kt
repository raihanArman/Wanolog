package com.randev.wanolog.android.utils

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class SharingCommentAttr {
    @OptIn(ExperimentalMaterialApi::class)
    val sheetHandler = SheetHandler(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
        confirmStateChange = {
            true
        }
    )

    val postId = MutableStateFlow("")

}