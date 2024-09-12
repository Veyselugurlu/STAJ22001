package com.example.filmler.data

import com.example.filmler.room.FilmlerDao
import com.example.filmler.ui.model.Filmler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var fdao: FilmlerDao) {
    suspend fun filmleriYukle() : List<Filmler> =
        withContext(Dispatchers.IO){
            return@withContext fdao.filmleriYukle()
        }
}
