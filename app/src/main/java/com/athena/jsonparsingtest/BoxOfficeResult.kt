package com.athena.jsonparsingtest


import com.google.gson.annotations.SerializedName


data class BoxOfficeResult(
    @SerializedName("boxofficeType")
    val boxofficeType: String?,

    @SerializedName("dailyBoxOfficeList")
    val dailyBoxOfficeList: List<DailyBoxOffice?>?,

    @SerializedName("showRange")
    val showRange: String?
)