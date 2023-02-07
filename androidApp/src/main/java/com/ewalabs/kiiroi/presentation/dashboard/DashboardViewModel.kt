package com.ewalabs.kiiroi.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.ewalabs.kiiroi.utils.SharingCommentAttr
import com.ewalabs.kiiroi.utils.navigation.AppWindowScreen

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class DashboardViewModel(
    private val commentAttr: SharingCommentAttr,
    private val appWindowScreen: AppWindowScreen
): ViewModel() {

    val postId = commentAttr.postId
    val sheetHandler = commentAttr.sheetHandler
    val displayType = appWindowScreen.appDisplayType

}