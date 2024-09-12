package com.example.filmler.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmler.data.FilmlerDataSource
import com.example.filmler.room.SharedPreferencesHelper
import com.example.filmler.ui.model.Filmler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(
    private val filmlerDataSource: FilmlerDataSource
) : ViewModel() {

    private val _sepetListesi = MutableLiveData<List<Filmler>>()
    val sepetListesi: LiveData<List<Filmler>> get() = _sepetListesi
    private val _filmListesi = mutableListOf<Filmler>()

    init {
        viewModelScope.launch {
            _sepetListesi.value = _filmListesi
            _sepetListesi.value = _filmListesi
        }
    }

    fun ekleSepete(film: Filmler) {
        // Sepet güncellemelerini yap
        val currentList = _sepetListesi.value?.toMutableList() ?: mutableListOf()
        currentList.add(film)
        _sepetListesi.value = currentList
    }
}
