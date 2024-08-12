package com.example.hiltkullanim.di

import com.example.hiltkullanim.Adres
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class )
class AppModule {
    //bir nesne olusturduk bunu bir çok class da kullaniyoruz singleton
    @Provides
    @Singleton
    fun provideAdres() : Adres {
        return Adres("Kadıkoy / İTANBUL")
    }
}