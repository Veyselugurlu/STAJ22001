package com.example.filmler.room

import android.content.Context
import android.content.SharedPreferences
import com.example.filmler.ui.model.Filmler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("favoriler", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveFavoriFilmler(filmlerList: List<Filmler>) {
        val json = gson.toJson(filmlerList)
        sharedPreferences.edit().putString("favori_filmler_listesi", json).apply()
    }

    fun getFavoriFilmler(): List<Filmler> {
        val json = sharedPreferences.getString("favori_filmler_listesi", null)
        return if (json != null) {
            val type = object : TypeToken<List<Filmler>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }
}