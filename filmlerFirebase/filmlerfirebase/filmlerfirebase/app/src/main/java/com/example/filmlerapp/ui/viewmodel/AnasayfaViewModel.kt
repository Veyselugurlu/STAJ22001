package com.example.filmlerapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.data.repo.FilmlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor( var frepo : FilmlerRepository) :ViewModel(){
    //viewmodelden fragmente veri tasimak istiyorsak livedata kullanmamiz lazim
    var filmlerListesi = MutableLiveData<List<Filmler>>()

    init {
        filmleriYukle()
    }
    //Coroutşine scope ile repo ve data sourcedeki ki asenkron yapıyi birtircez
    fun filmleriYukle(){
            filmlerListesi  = frepo.filmleriYukle()
    }

}