package com.example.mvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel() {
    //liveData
    var sonuc = MutableLiveData("0")
    var drepo= DataRepo()

    fun toplamaYap(alinanSayi1:String , alinanSayi2:String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = drepo.toplamaYap(alinanSayi1,alinanSayi2)
        }
    }

    fun carpmaYap(alinanSayi1:String , alinanSayi2:String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = drepo.carpmaYap(alinanSayi1,alinanSayi2)
        }
    }
}