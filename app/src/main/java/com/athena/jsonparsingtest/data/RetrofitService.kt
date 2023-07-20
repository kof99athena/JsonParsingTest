package com.athena.jsonparsingtest.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RetrofitService {
    //인터페이스 안에는 추상 메소드만 갖고있다.
    //Retrofit에게 일을 시키기 위한 요구 명세서를 쓰자 (레트로핏이 할일들)
    //내가 직접 기능을 구현하는게아니다. 레트로핏이 그 일일 대신한다.

    //GET방식으로 가져온다.
    @GET("searchDailyBoxOfficeList.json")
    fun getBoardJson(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String
    ): Call<Item>
}