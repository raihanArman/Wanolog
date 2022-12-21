package com.randev.work_manager.repository

import com.randev.work_manager.QuoteWorkManager

/**
 * @author Raihan Arman
 * @date 20/12/22
 */
class QuoteTaskRepositoryImpl(
    val quoteWorkManager: QuoteWorkManager
): QuoteTaskRepository {
    override fun executeQuoteWorker() {
        quoteWorkManager.execute()
    }
}