package com.ewalabs.kiiroi.utils.navigation

import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 02/02/23
 */
val windowScreenModule = module {
    single<AppWindowScreen> { AppWindowScreenImpl() }
}