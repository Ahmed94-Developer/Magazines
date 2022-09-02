package com.example.myapplication.di

import com.example.myapplication.retrofit.api.DataApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetWorkModule {
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
    }
    @Singleton
    @Provides
    fun provideDataApi(retrofit: Retrofit) : DataApi{
        return retrofit.create(DataApi::class.java)
    }

}