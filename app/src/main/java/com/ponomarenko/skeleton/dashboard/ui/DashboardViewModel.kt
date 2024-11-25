package com.ponomarenko.skeleton.dashboard.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ponomarenko.skeleton.data.network.ApiGateway
import com.ponomarenko.skeleton.data.network.model.ItemOverview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class DashboardViewModel(val apiGateway: ApiGateway) : ViewModel() {

    private val items = MutableLiveData<List<ItemOverview>>()

    init {

        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                apiGateway.getAllData()
                    .let {
                        items.postValue(it)
                    }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}