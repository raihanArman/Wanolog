package com.randev.wanolog.android.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.randev.wanolog.android.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

val featureModule = module {
    viewModel { HomeViewModel(get(), get()) }
}