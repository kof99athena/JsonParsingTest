package com.athena.jsonparsingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.athena.jsonparsingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            //버튼 눌렀을때 GET방식으로 JSON문서를 호출해오자
            //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
        }
    }
}