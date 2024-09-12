package com.example.filmler.data

import com.example.filmler.ui.model.Filmler

class FilmlerRepository( var fds : FilmlerDataSource) {

    suspend fun filmleriYukle() : List<Filmler> = fds.filmleriYukle()

}