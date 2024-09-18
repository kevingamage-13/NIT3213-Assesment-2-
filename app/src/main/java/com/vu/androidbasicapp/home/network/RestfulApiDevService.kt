package com.vu.androidbasicapp.home.network

import com.vu.androidbasicapp.home.data.DashboardResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RestfulApiDevService {

    // Fetches dashboard data based on the keypass
    @GET("dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): DashboardResponse
}
