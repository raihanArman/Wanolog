package com.randev.wanolog.android.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.randev.wanolog.android.utils.SharingCommentAttr

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class DashboardViewModel(
    private val commentAttr: SharingCommentAttr
): ViewModel() {

    val postId = commentAttr.postId
    val sheetHandler = commentAttr.sheetHandler
}