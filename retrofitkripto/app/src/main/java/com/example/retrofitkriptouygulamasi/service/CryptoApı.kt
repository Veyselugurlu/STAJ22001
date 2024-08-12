package com.example.retrofitkriptouygulamasi.service

import com.example.retrofitkriptouygulamasi.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface CryptoApi {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    suspend fun getData(): Response<List<CryptoModel>>
    //fun getData(): Call<List<CryptoModel>>
}