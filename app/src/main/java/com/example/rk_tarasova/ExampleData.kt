package com.example.rk_tarasova

import com.squareup.moshi.Json

data class ExampleData(
    val jsonFieldName: String,
    @Json(name = "other_format_field_name") val OtherFormatFieldName: String
)