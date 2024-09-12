package com.example.filmlerapp.di

import com.example.filmlerapp.data.datasource.FilmlerDatasource
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.data.repo.FilmlerRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.processNextEventInCurrentThread
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFilmlerDataSources(collectionFilmler: CollectionReference): FilmlerDatasource {
        return FilmlerDatasource(collectionFilmler)
    }
    @Provides
    @Singleton
    fun provideFilmlerRepository(fds: FilmlerDatasource): FilmlerRepository {
        return FilmlerRepository(fds)
    }

    @Provides
    @Singleton
    fun provideCollectionReference(): CollectionReference {
        return Firebase.firestore.collection("Filmler")
    }

}