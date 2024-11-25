package com.ponomarenko.skeleton.data.network

import com.ponomarenko.skeleton.data.network.model.ItemDetails
import com.ponomarenko.skeleton.data.network.model.ItemOverview

interface ApiGateway {

    suspend fun getAllData(): List<ItemOverview>

    suspend fun getItemDetails(): ItemDetails
}