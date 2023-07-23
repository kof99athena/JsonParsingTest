package com.athena.jsonparsingtest

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.athena.jsonparsingtest.databinding.ActivityMainBinding
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {

            val key = "3d4d195993be83f612873e55e67eac16"
            val targetDt = "20230703"

            val builder = Retrofit.Builder()
            builder.baseUrl("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/")
            builder.addConverterFactory(GsonConverterFactory.create()).build()

            val retrofit: Retrofit = builder.build()
            val retrofitService: RetrofitService = retrofit.create(RetrofitService::class.java)

            val call = retrofitService.getBoardJson(key, targetDt)
            call.enqueue(object : Callback<com.athena.jsonparsingtest.Response>{
                override fun onResponse(
                    call: Call<com.athena.jsonparsingtest.Response>,
                    response: Response<com.athena.jsonparsingtest.Response>
                ) {
                    val res = response.body()
                    val list : List<DailyBoxOffice?>? = res!!.boxOfficeResult!!.dailyBoxOfficeList

                    val name = list?.mapNotNull {
                        it?.movieNm
                    }

                    val nameText = name?.joinToString("\n") ?: ""
                    //joinToString  : 컬렉션(배열, 리스트 등)의 요소들을 하나의 문자열로 결합해준다.
                    //separator를 지정하여 원하는 형태로 만들수있다. ex 띄어쓰기

                    binding.tv.text = nameText

                    Log.i("title",list.toString())
                }

                override fun onFailure(
                    call: Call<com.athena.jsonparsingtest.Response>,
                    t: Throwable
                ) {

                }
            })

        }//리스너
    }//onCreate
}