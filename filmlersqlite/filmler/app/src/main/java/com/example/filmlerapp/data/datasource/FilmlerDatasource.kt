package com.example.filmlerapp.data.datasource

import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.room.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDatasource(var fdao: FilmlerDao) {
    suspend fun filmlriYukle() : List<Filmler> =
        //veritabanı işe calistigimiz icin IO kullandık
        withContext(Dispatchers.IO) {



        return@withContext fdao.filmleriYukle()
        }
}