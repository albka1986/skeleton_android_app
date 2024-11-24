package com.ponomarenko.skeleton.infrastructure.di

import com.ponomarenko.skeleton.dashboard.di.DashboardModule


object InjectionModules {

    val modules = listOf(
        DashboardModule.module
    )
}