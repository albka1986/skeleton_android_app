package com.ponomarenko.skeleton.infrastructure.ui

sealed class Screen(val route: String) {
    data object Dashboard : Screen("dashboard_screen")
    data object Details : Screen("detail_screen")
}