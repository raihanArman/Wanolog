package com.ewalabs.work_manager.repository

import com.ewalabs.work_manager.QuoteWorkManager

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