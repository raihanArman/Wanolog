package com.ewalabs.widget

import android.content.Context
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.appwidget.updateAll

/**
 * @author Raihan Arman
 * @date 20/12/22
 */
class QuoteWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = QuoteWidget()

    companion object {
        suspend fun updateWidget(quote: String, anime: String, context: Context) {
            val glanceId = GlanceAppWidgetManager(context).getGlanceIds(QuoteWidget::class.java).last()
            updateAppWidgetState(context, glanceId) { prefs ->
                prefs[QuoteWidget.quoteKeyPreference] = quote
                prefs[QuoteWidget.quoteAnimeKeyPreference] = anime
            }
            QuoteWidget().updateAll(context)
        }
    }

}