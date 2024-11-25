package com.ponomarenko.skeleton.data.network

import com.ponomarenko.skeleton.data.network.model.ItemDetails
import com.ponomarenko.skeleton.data.network.model.ItemOverview
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import timber.log.Timber

class ApiRemoteGateway(val client: HttpClient) : ApiGateway {

    override suspend fun getAllData(): List<ItemOverview> {
        val httpResponse: HttpResponse = client.get("todos")
        return if (httpResponse.status.value in 200..299) {
            Timber.d("Successful response!")
            val body: List<ItemOverview> = httpResponse.body()
            body
        } else {
            throw Exception("Something went wrong!")
        }
    }

    override suspend fun getItemDetails(): ItemDetails {

        //todo
        val httpResponse: HttpResponse = client.get("todos")
        return if (httpResponse.status.value in 200..299) {
            println("Successful response!")
            httpResponse.body<ItemDetails>()
        } else {
            throw Exception("Something went wrong!")
        }
    }
}