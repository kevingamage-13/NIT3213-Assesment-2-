package com.vu.androidbasicapp.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    val greetingText = MutableStateFlow("Hello Class")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())
    private val restfulDevApiService = RestfulApiDevRetrofitClient().apiService

    init {
        Log.d("nit3213", "HomeScreenViewModel ViewModel initialized")
    }

    private fun fetchDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val result = restfulDevApiService.getDashboardData(keypass)
                apiResponseObjects.value = result.entities
                Log.d("DashboardData", result.entities.toString())
            } catch (e: Exception) {
                Log.e("DashboardError", e.message ?: "Unknown error")
            }
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}
