package com.ponomarenko.skeleton.details.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(id: String) {
    val viewmodel = koinViewModel<DetailsViewModel>()

    Text(
        text = "Details screen $id"
    )
}