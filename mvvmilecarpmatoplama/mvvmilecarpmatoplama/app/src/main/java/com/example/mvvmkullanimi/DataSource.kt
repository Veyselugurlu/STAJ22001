package com.example.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSource {
    //suspend => asenkron bir sekikde veriyi iletir
    suspend fun toplamaYap(alinanSayi1:String , alinanSayi2:String) : String
    //veritabanı islemi => IO
    = withContext(Dispatchers.IO){
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplama = sayi1 + sayi2
        return@withContext  toplama.toString()
    }

    suspend fun carpmaYap(alinanSayi1:String , alinanSayi2:String):String
    = withContext(Dispatchers.IO){
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val carpma = sayi1 * sayi2
        return@withContext  carpma.toString()
    }

}