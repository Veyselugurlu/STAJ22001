package com.example.filmler.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmler.ui.model.Filmler

@Database(entities = [Filmler::class] , version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun getFilmlerDao(): FilmlerDao
}