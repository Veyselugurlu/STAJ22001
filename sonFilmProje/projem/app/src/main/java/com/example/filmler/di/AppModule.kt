package com.example.filmler.di

import android.content.Context
import androidx.room.Room
import com.example.filmler.data.FilmlerDataSource
import com.example.filmler.data.FilmlerRepository
import com.example.filmler.room.FilmlerDao
import com.example.filmler.room.SharedPreferencesHelper
import com.example.filmler.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providerFilmlerDataSource(fdao: FilmlerDao): FilmlerDataSource{
            return FilmlerDataSource(fdao)
    }

    @Provides
    @Singleton
    fun providerFilmlerRepository(fds:FilmlerDataSource) : FilmlerRepository{
        return  FilmlerRepository(fds)
    }
    @Provides
    @Singleton
    fun providerFilmlerDao(@ApplicationContext context: Context): FilmlerDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"filmler_appi.sqlite")
            .createFromAsset("filmler_appi.sqlite").build()
        return vt.getFilmlerDao()
    }
    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(@ApplicationContext context: Context): SharedPreferencesHelper {
        return SharedPreferencesHelper(context)
    }

}