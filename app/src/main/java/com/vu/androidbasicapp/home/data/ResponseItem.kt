package com.vu.androidbasicapp.home.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseItem(
    @Json(name = "technique") val technique: String,
    @Json(name = "equipment") val equipment: String,
    @Json(name = "subject") val subject: String,
    @Json(name = "pioneeringPhotographer") val pioneeringPhotographer: String,
    @Json(name = "yearIntroduced") val yearIntroduced: Int,
    @Json(name = "description") val description: String
) : Parcelable

@Parcelize
data class DashboardResponse(
    @Json(name = "entities") val entities: List<ResponseItem>,
    @Json(name = "entityTotal") val entityTotal: Int
) : Parcelable
