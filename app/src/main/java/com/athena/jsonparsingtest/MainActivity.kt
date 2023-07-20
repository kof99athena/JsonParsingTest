package com.athena.jsonparsingtest

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RestrictTo
import com.athena.jsonparsingtest.data.RetrofitService
import com.athena.jsonparsingtest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn2.setOnClickListener {
            val intent : Intent = Intent(this,WebviewActivity::class.java)
            startActivity(intent)
        }


        binding.btn1.setOnClickListener {
            //버튼 눌렀을때 GET방식으로 JSON문서를 호출해오자
            //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()

            val key = "f5eef3421c602c6cb7ea224104795888"
            val targetDt = "20120716"

            val builder = Retrofit.Builder()
            builder.baseUrl("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/")
            builder.addConverterFactory(GsonConverterFactory.create())
            val retrofit : Retrofit = builder.build()
            //converter를 만는 공장을 세우고, 필요할때마다 gson이 알아서 처리하게 명령내림.
            //converter는 gson과 retrofit2를 연결해주는 라이브러리
            //retrofit에게 gson이 필요할때마다 쓰겠다고 명령 내린것임.

            //이제 인터페이스에 적혀있는 명세서대로 retrofit이 그 동작들을 대신해준다.
            val retrofitService : RetrofitService = retrofit.create(RetrofitService::class.java)// 다시확인

            val call : Call<com.athena.jsonparsingtest.data.Item> = retrofitService.getBoardJson(key,targetDt)
            //서비스 객체의 추상메소드를 받아와서 실제 네트워크 작업하는 Call객체 불러오기

            //call이 실제로 네트워크 작업을 진행한다.
            call.enqueue(object : retrofit2.Callback<com.athena.jsonparsingtest.data.Item> {
                override fun onResponse(call: Call<com.athena.jsonparsingtest.data.Item>, response: Response<com.athena.jsonparsingtest.data.Item>) {
                   if (response.isSuccessful){
                       val item = response.body()

                       Log.i("isSuccessful",item.toString())
                       // response.body()의 결과를 null 체크하여 movieNm을 가져오거나 기본값으로 빈 문자열 처리
                       var movieNm: String = item?.movieNm ?: "null"

                       binding.tv.text = movieNm
                       Log.i("title",binding.tv.text.toString())
                   }else{
                       Toast.makeText(this@MainActivity, "${response.code()}", Toast.LENGTH_SHORT).show()
                   }
                }

                override fun onFailure(call: Call<com.athena.jsonparsingtest.data.Item>, t: Throwable) {
                    binding.tv.text = t.toString()
                }
            })

        }//리스너

    }
}