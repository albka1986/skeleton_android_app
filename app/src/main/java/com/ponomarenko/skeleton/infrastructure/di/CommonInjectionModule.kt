package com.ponomarenko.skeleton.infrastructure.di

import com.ponomarenko.skeleton.data.network.ApiGateway
import com.ponomarenko.skeleton.data.network.ApiRemoteGateway
import com.ponomarenko.skeleton.data.network.NetworkClientProvider
import io.ktor.client.HttpClient
import org.koin.dsl.module

object CommonInjectionModule {

    val module = module {

        single<HttpClient> {
            NetworkClientProvider().buildClient()
        }

        factory<ApiGateway> {
            ApiRemoteGateway(
                client = get()
            )
        }
    }
}