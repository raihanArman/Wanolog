package com.ewalabs.kiiroi.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.content.FileProvider
import com.ewalabs.kiiroi.BuildConfig
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * @author Raihan Arman
 * @date 12/10/22
 */

fun emptyString() = ""


@OptIn(ExperimentalMaterialApi::class)
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val fraction = bottomSheetState.progress.fraction
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when{
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 1f
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 0f
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> 1f - fraction
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Collapsed -> 0f + fraction
            else -> fraction
        }
    }

fun File?.toUriPath(context: Context): Uri? {
    return this?.let {
        FileProvider.getUriForFile(
            context, BuildConfig.APPLICATION_ID, it
        )
    }
}

fun Bitmap?.bitmapToCacheUri(context: Context?): Uri?{
    var bmpUri: Uri? = null
    try{
        val file = File(context?.externalCacheDir, System.currentTimeMillis().toString() + ".jpg")
        val out = FileOutputStream(file)
        this?.compress(Bitmap.CompressFormat.JPEG, 90, out)
        out.close()
        bmpUri = context?.let { file.toUriPath(it) }
    }catch (e: IOException){
        e.printStackTrace()
    }

    return bmpUri
}
