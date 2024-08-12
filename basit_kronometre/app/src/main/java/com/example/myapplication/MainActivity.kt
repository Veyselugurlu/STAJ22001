package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var number = 0
    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler(Looper.getMainLooper())   // runnable kullanabilmemiz icin kullanilan sinif


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun start(view: View){
        number = 0
        runnable = object : Runnable{
            override fun run() {
                number = number +1
                binding.textView.text = "Time : ${number}"
                handler.postDelayed(runnable , 1000)  //rotarli olarak runnable yapicak

            }
        }

        handler.post(runnable)    // runnableyi başlatmak icin gerkeli
        binding.start.isEnabled = false


    }
    fun stop(view: View){
        binding.start.isEnabled = true
        number = 0
        binding.textView.text = "Time 0"
        handler.removeCallbacks(runnable)  //runanble'yi durduma islemi


    }
}