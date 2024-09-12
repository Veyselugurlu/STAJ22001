package com.example.filmler.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.filmler.ui.model.Filmler

@Dao
interface FilmlerDao {

    @Query("SELECT * FROM filmleri")
    suspend fun filmleriYukle() : List<Filmler>
   //favorilere kelme işlemi

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun favorilereEkle(film: Filmler)

}