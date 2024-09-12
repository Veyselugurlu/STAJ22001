package com.example.retrofitkriptouygulamasi.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkriptouygulamasi.adapter.RecyclerViewAdapter
import com.example.retrofitkriptouygulamasi.databinding.ActivityMainBinding
import com.example.retrofitkriptouygulamasi.model.CryptoModel
import com.example.retrofitkriptouygulamasi.service.CryptoApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.*
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.Listener {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var cryptoModels: ArrayList<CryptoModel>? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private lateinit var binding: ActivityMainBinding
    private var job : Job? =null
    val exceptionHandler = CoroutineExceptionHandler{coroutineContext,throwable->
    println("Error: ${throwable.localizedMessage}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView ve LayoutManager'ı tanımlama
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadData()
    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getData()

           withContext(Dispatchers.Main + exceptionHandler){
               if (response.isSuccessful){
                   response.body()?.let {  //verilen model boş değilse
                       cryptoModels = ArrayList(it)
                       cryptoModels?.let {
                           recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
                           binding.recyclerView.adapter = recyclerViewAdapter
                       }
                   }
               }
           }
        }



/*
  val service = retrofit.create(CryptoApi::class.java)
  val call = service.getData()
        call.enqueue(object : Callback<List<CryptoModel>> {
            override fun onResponse(call: Call<List<CryptoModel>>, response: Response<List<CryptoModel>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        cryptoModels = ArrayList(it)
                        cryptoModels?.let {
                            recyclerViewAdapter = RecyclerViewAdapter(cryptoModels!!, this@MainActivity)
                            binding.recyclerView.adapter = recyclerViewAdapter // Doğru ID'yi kullanın
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })
        */
    }

    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(applicationContext, "Clicked ${cryptoModel.currency}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()

    }
}
