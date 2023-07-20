package com.athena.jsonparsingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.webkit.WebViewClient
import com.athena.jsonparsingtest.databinding.ActivityMainBinding
import com.athena.jsonparsingtest.databinding.ActivityWebviewBinding

class WebviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.webview.apply {
           webViewClient = WebViewClient()
           settings.javaScriptEnabled =true
       }
       binding.webview.loadUrl("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230703")
    }

    override fun onBackPressed() {
        if (binding.webview.canGoBack()){
            binding.webview.goBack()
        }else{
            finish()
        }
    }
}