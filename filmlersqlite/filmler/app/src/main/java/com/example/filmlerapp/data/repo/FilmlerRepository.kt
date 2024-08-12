package com.example.filmlerapp.data.repo

import com.example.filmlerapp.data.datasource.FilmlerDatasource
import com.example.filmlerapp.data.entity.Filmler

class FilmlerRepository {

    var fds = FilmlerDatasource()
    //repodan aldigimiz filmleri verdik fonksiyona
    suspend fun filmleriYukle() : List<Filmler> = fds.filmlriYukle()

}