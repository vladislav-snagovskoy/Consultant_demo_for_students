package com.example.test_project_for_internal_use.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainElement(

    @Json(name = "name")
    val name: String = "name",

    @Json(name = "count")
    val count: Int = 0
)