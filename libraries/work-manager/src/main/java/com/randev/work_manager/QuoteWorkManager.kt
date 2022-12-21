package com.randev.work_manager

import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ListenableWorker
import androidx.work.NetworkType
import androidx.work.Operation
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

/**
 * @author Raihan Arman
 * @date 20/12/22
 */
class QuoteWorkManager(
    private val workManager: WorkManager
) {
    fun execute() = enqueueWorker()

    private fun enqueueWorker() {
        println("QuoteWorkManager -> execute")
        workManager.enqueueUniquePeriodicWork(
            QUOTE_TAG,
            ExistingPeriodicWorkPolicy.KEEP,
            buildRequest()
        )
    }

    private fun buildRequest(): PeriodicWorkRequest {
        return PeriodicWorkRequestBuilder<QuoteTask>(24, TimeUnit.HOURS)
            .addTag(QUOTE_TAG)
            .setConstraints(getDRMConstraints())
            .build()
    }

    companion object {
        const val QUOTE_TAG = "quote_tag"
        private fun getDRMConstraints(): Constraints {
            return Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()
        }
    }

}