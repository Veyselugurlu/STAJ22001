package com.example.catchthecannykotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.catchthecannykotlin.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding   // arayuz bileşenine erişim sağlar
    var score =0
    var imageArray = ArrayList<ImageView>()
    var runnable = Runnable{}
    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)

        hideImages()
        //CountDownTimer
        object : CountDownTimer(15500, 1000){
            //her sanşyede ne olacagi
            override fun onTick(p0: Long) {
                 binding.time.text = "Time : ${p0/1000}"
            }
            //bittiginde ne olacagi
            override fun onFinish() {
                binding.time.text = "Time : 0"
                handler.removeCallbacks(runnable)  //runnabl durdurma
                //sure bittikten sonra image kaybolcak
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                //tekrar oynamak isterse

                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart Th Game ?")
                alert.setPositiveButton("Yes",{dialogInterface,i ->
                    //restart

                    val intentFromMain = intent // Mevcut aktivitenin başlatılma niyetini alır
                    finish()                    //mevcut aktivite kapatılır ve bellekten kaldırılır.
                    startActivity(intentFromMain)  // Aynı niyetle yeni bir aktivite başlatır
                    })

                alert.setNegativeButton("No",{dialogInterface, i->
                    Toast.makeText(
                        this@MainActivity,
                        "Game Over!",
                        Toast.LENGTH_LONG).show()
                })

                //alerti goster
                alert.show()
            }
        }.start()
    }

    fun hideImages(){

        runnable = object : Runnable{
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility =  View.VISIBLE
                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)
    }

    fun increaseScore(view : View){
        score = score + 1
        binding.scor.text = "Score : ${score}"

    }
}