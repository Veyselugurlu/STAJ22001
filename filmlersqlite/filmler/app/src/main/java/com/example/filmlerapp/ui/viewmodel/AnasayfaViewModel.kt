package com.example.filmlerapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.data.repo.FilmlerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel :ViewModel(){

    var frepo = FilmlerRepository()

    //viewmodelden fragmente veri tasimak istiyorsak livedata kullanmamiz lazim
    var filmlerListesi = MutableLiveData<List<Filmler>>()

    init {
        filmleriYukle()
    }

    //Coroutşine scope ile repo ve data sourcedeki ki asenkron yapıyi birtircez
    fun filmleriYukle(){
        //arayuz ile islem yapacagimiz icin main kullandik
        CoroutineScope(Dispatchers.Main).launch {
           //veritabanindan gelenbilgiyi buna aticaz
            filmlerListesi.value  = frepo.filmleriYukle()

        }
    }

}