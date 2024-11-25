package com.ponomarenko.skeleton.infrastructure.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ponomarenko.skeleton.dashboard.ui.DashboardScreen
import com.ponomarenko.skeleton.details.ui.DetailsScreen
import com.ponomarenko.skeleton.infrastructure.ui.Screen.Dashboard
import com.ponomarenko.skeleton.infrastructure.ui.Screen.Details

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Dashboard.route) {
        composable(route = Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(
            route = Details.route + "?id={id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            DetailsScreen(id = it.arguments?.getString("id") ?: "1")
        }
    }
}