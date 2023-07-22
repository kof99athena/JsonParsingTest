package com.athena.jsonparsingtest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("searchDailyBoxOfficeList.json")
    fun getBoardJson(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String
    ): Call<Response>
}