package com.ponomarenko.skeleton.details.di

import com.ponomarenko.skeleton.details.ui.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DetailsModule {

    val module = module {
        viewModel {
            DetailsViewModel(
                apiGateway = get()
            )
        }
    }
}