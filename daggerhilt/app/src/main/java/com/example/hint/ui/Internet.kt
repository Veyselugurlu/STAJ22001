package com.example.hint.ui

import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor(var adres: Adres) {

    fun basvuruYap() {
        Log.e("Sonuç", "Internet Basvurusu ${adres.adresBilgisi} adrsine yapıldı")
    }

}