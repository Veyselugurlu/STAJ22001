package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao:KisilerDao) {


    suspend fun Kaydet(kisi_ad:String,kisi_tel:String)=
        //inteface aktrdık
       kdao.kaydet(kisi_ad,kisi_tel)


    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) = kdao.gucelle(kisi_id,kisi_ad,kisi_tel)


    suspend fun sil(kisi_id:Int) = kdao.sil(kisi_id)

    suspend fun kisileriYukle():List<Kisiler> =
        withContext(Dispatchers.IO)
        {

            return@withContext kdao.kisileriYukle().kisiler
    }

    suspend fun ara(aramaKelimesi : String) : List<Kisiler> =
    withContext(Dispatchers.IO)
    {
        return@withContext kdao.ara(aramaKelimesi).kisiler
    }
}