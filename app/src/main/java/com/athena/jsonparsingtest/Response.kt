package com.athena.jsonparsingtest


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult?
)