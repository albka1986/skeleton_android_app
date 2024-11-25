package com.ponomarenko.skeleton.infrastructure.di

import com.ponomarenko.skeleton.dashboard.di.DashboardModule
import com.ponomarenko.skeleton.details.di.DetailsModule


object InjectionModules {

    val modules = listOf(
        CommonInjectionModule.module,
        DashboardModule.module,
        DetailsModule.module
    )
}