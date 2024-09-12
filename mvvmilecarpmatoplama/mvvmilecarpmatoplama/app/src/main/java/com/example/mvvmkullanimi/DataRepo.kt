package com.example.mvvmkullanimi

class DataRepo {
    var ds = DataSource()
    suspend fun toplamaYap(alinanSayi1:String , alinanSayi2:String) : String
    //return degeri ile ayni islevi gorur
    = ds.toplamaYap(alinanSayi1,alinanSayi2)

    suspend fun carpmaYap(alinanSayi1:String , alinanSayi2:String) : String
    = ds.carpmaYap(alinanSayi1,alinanSayi2)

}