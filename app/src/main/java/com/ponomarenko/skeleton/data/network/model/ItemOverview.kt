package com.ponomarenko.skeleton.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemOverview(

    @SerialName("userId") var userId: Int? = null,
    @SerialName("id") var id: Int? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("completed") var completed: Boolean? = null
)