package com.athena.jsonparsingtest


import com.google.gson.annotations.SerializedName


data class DailyBoxOffice(

    @SerializedName("movieNm")
    val movieNm: String?
)