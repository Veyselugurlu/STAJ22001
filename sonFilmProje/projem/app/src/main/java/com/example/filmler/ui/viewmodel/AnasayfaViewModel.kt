package com.example.filmler.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmler.data.FilmlerRepository
import com.example.filmler.room.SharedPreferencesHelper
import com.example.filmler.ui.model.Filmler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(private val frepo: FilmlerRepository,
                                            private val sharedPreferencesHelper: SharedPreferencesHelper) : ViewModel() {

    var filmlerListesi = MutableLiveData<List<Filmler>>()
    private val _favoriFilmlerListesi = MutableLiveData<List<Filmler>>()
    val favoriFilmlerListesi: LiveData<List<Filmler>> = _favoriFilmlerListesi

    private val favoriFilmler = mutableListOf<Filmler>()

    init {
        filmleriYukle()
    }

    fun filmleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            filmlerListesi.value = frepo.filmleriYukle()
        }
    }

    fun filmFavorilereEkle(film: Filmler) {
        val favoriFilmler = _favoriFilmlerListesi.value?.toMutableList() ?: mutableListOf()

        if (!favoriFilmler.contains(film)) {
            favoriFilmler.add(film)
            _favoriFilmlerListesi.value = favoriFilmler.toList()
            sharedPreferencesHelper.saveFavoriFilmler(favoriFilmler)
        }
    }

}
