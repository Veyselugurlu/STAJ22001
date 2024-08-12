package com.example.filmlerapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.filmlerapp.data.datasource.FilmlerDatasource
import com.example.filmlerapp.data.entity.Filmler

class FilmlerRepository(var fds : FilmlerDatasource) {
    //repodan aldigimiz filmleri verdik fonksiyona
    fun filmleriYukle() : MutableLiveData<List<Filmler>> = fds.filmlriYukle()

}