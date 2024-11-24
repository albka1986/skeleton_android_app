package com.ponomarenko.skeleton.dashboard.di

import com.ponomarenko.skeleton.dashboard.ui.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DashboardModule {

    val module = module {
        viewModel { DashboardViewModel() }
    }
}