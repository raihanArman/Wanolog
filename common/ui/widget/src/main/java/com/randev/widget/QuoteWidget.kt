package com.randev.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.ImageProvider
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontStyle
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

/**
 * @author Raihan Arman
 * @date 20/12/22
 */
class QuoteWidget : GlanceAppWidget() {
    override val sizeMode: SizeMode
        get() = SizeMode.Exact

    @Composable
    override fun Content() {
        val state = currentState<Preferences>()
        val quote = state[quoteKeyPreference] ?: ""
        val anime = state[quoteAnimeKeyPreference] ?: ""
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(ImageProvider(R.drawable.background_widget))
                .clickable(actionRunCallback<ActionUpdate>()),
        ) {
            Text(
                text = "Quote of the day",
                modifier = GlanceModifier.padding(10.dp),
                style = TextStyle(
                    color = ColorProvider(R.color.widget_text_color),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Text(
                text = anime,
                modifier = GlanceModifier.padding(horizontal = 10.dp),
                style = TextStyle(
                    color = ColorProvider(R.color.widget_text_color),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            )
            Text(
                text = quote,
                modifier = GlanceModifier.padding(horizontal = 10.dp),
                style = TextStyle(
                    color = ColorProvider(R.color.widget_text_color),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic
                )
            )
        }
    }

    companion object {
        private const val QUOTE_KEY = "com.randev.wanolog.android.widget.quote_key"
        private const val QUOTE_ANIME_KEY = "com.randev.wanolog.android.widget.quote_anime_key"
        val quoteKeyPreference =
            stringPreferencesKey(QUOTE_KEY)
        val quoteAnimeKeyPreference =
            stringPreferencesKey(QUOTE_ANIME_KEY)
    }

}

class ActionUpdate : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {

    }
}