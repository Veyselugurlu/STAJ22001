package com.example.filmler.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmler.room.SharedPreferencesHelper
import com.example.filmler.ui.model.Filmler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriViewModel @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper // Inject edilme işlemi burada doğru şekilde yapılıyor

) : ViewModel() {

    private val _favoriFilmlerListesi = MutableLiveData<List<Filmler>>(mutableListOf())
    val favoriFilmlerListesi: LiveData<List<Filmler>> get() = _favoriFilmlerListesi

    init {
        // Başlangıçta favori filmleri SharedPreferences'tan yükle
        _favoriFilmlerListesi.value = sharedPreferencesHelper.getFavoriFilmler().toMutableList()
    }
   fun filmFavorilereEkle(film: Filmler) {
        val currentList = _favoriFilmlerListesi.value?.toMutableList() ?: mutableListOf()
        if (!currentList.contains(film)) {
            currentList.add(film)
            _favoriFilmlerListesi.value = currentList
            sharedPreferencesHelper.saveFavoriFilmler(currentList)
        }
    }
    fun getFavoriteFilms() {
        _favoriFilmlerListesi.value = sharedPreferencesHelper.getFavoriFilmler()
    }

    fun filmFavorilerdeMi(film: Filmler): Boolean {
        return _favoriFilmlerListesi.value?.contains(film) == true
    }
}
