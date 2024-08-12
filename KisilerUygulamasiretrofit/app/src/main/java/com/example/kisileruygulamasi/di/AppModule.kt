package com.example.kisileruygulamasi.di

import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import com.example.kisileruygulamasi.retrofit.ApiUtils
import com.example.kisileruygulamasi.retrofit.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesKisilerDataSource(kdao:KisilerDao): KisilerDataSource{
        return KisilerDataSource(kdao)
    }

    @Provides
    @Singleton
    fun providesKisilerRepository(kds:KisilerDataSource): KisilerRepository{
        return KisilerRepository(kds)
    }
    @Provides
    @Singleton
    fun providesKisilerDao(): KisilerDao{
        return ApiUtils.getKisilerDao()
    }



}