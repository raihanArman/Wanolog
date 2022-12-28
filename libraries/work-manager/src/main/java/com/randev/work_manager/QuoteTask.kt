package com.randev.work_manager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.randev.data.datasource.remote.QuoteApiClient
import com.randev.widget.QuoteWidgetReceiver
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * @author Raihan Arman
 * @date 20/12/22
 */
class QuoteTask(
    private val context: Context,
    workParams: WorkerParameters,
) : CoroutineWorker(context, workParams), KoinComponent  {

    private val api: QuoteApiClient by inject()

    companion object{
        private const val MAXIMUM_RETRIES = 3
    }

    override suspend fun doWork(): Result {
        if (runAttemptCount >= MAXIMUM_RETRIES) return Result.failure()

        return try {
            val randomQuoteFromApi = api.fetchQuoteRandom()
            val quote = randomQuoteFromApi.quote
            val anime = randomQuoteFromApi.anime
            println("Quote Task -> $quote")
            if (quote != null && anime != null) {
                QuoteWidgetReceiver.updateWidget(quote, anime ,context)
                Result.success()
            } else {
                Result.retry()
            }
        } catch (e: Exception) {
            println("Quote Task -> $e")
            e.printStackTrace()
            Result.retry()
        }
    }

}