package com.ponomarenko.skeleton.dashboard.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ponomarenko.skeleton.infrastructure.ui.Screen
import org.koin.androidx.compose.koinViewModel


@Composable
fun DashboardScreen(navController: NavController) {

    val viewModel = koinViewModel<DashboardViewModel>()

    Box {
        LazyColumn {
            items(100) {
                Card(
                    onClick = {
//                        navController.navigate(route = Screen.Details.route + "?id=${it}")
                    }
                ) {
                    Text(text = "item $it")
                }
            }
        }
    }
}