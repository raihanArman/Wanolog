package com.ewalabs.kiiroi.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.lang.Exception

/**
 * @author Raihan Arman
 * @date 18/12/22
 */
object IntentUtils {
    fun shareImage(context: Context?, uri: Uri){
        val chooserIntent = Intent(Intent.ACTION_SEND)
        chooserIntent.type = "image/*"
        chooserIntent.putExtra(Intent.EXTRA_TEXT, "Share Quote")
        chooserIntent.putExtra(Intent.EXTRA_STREAM, uri)
        chooserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        try {
            context?.startActivity(chooserIntent)
        } catch (ex: Exception) {
        }
    }
}