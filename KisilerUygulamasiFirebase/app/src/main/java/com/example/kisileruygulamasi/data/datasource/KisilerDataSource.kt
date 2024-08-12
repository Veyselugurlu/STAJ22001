package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.ui.fragment.KisiDetayFragment_GeneratedInjector
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var collectionKisiler : CollectionReference) {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    fun Kaydet(kisi_ad:String,kisi_tel:String){
        val yeniKisi = Kisiler("",kisi_ad,kisi_tel)
        collectionKisiler.document().set(yeniKisi)

    }

    fun guncelle(kisi_id:String,kisi_ad:String,kisi_tel:String){
        val guncellenKisi = HashMap<String,Any>()
        guncellenKisi["kisi_ad"] = kisi_ad
        guncellenKisi["kisi_tel"] = kisi_tel
        collectionKisiler.document(kisi_id).update(guncellenKisi)
    }

    fun sil(kisi_id:String){
        collectionKisiler.document(kisi_id).delete()
    }

    fun kisileriYukle(): MutableLiveData<List<Kisiler>>{
        //gercek zamanli veri okumamizi saglar
        collectionKisiler.addSnapshotListener{
            value,error->
            if (value != null){
                val liste = ArrayList<Kisiler>()

                for (d in value.documents){
                    val kisi = d.toObject(Kisiler::class.java)
                    if (kisi!=null){
                        kisi.kisi_id = d.id
                        liste.add(kisi)
                    }
                }
                kisilerListesi.value = liste
            }

        }
        return  kisilerListesi
         }


    fun ara(aramaKelimesi : String) :  MutableLiveData<List<Kisiler>>{
        collectionKisiler.addSnapshotListener { value, error ->
            if (value != null){
                val liste = ArrayList<Kisiler>()

                for (d in value.documents){
                    val kisi = d.toObject(Kisiler::class.java)
                    if (kisi != null){
                        if (kisi.kisi_ad!!.lowercase().contains(aramaKelimesi.lowercase())){
                            kisi.kisi_id = d.id
                            liste.add(kisi)
                        }
                    }
                }
                kisilerListesi.value = liste
            }
        }
        return kisilerListesi
    }
}