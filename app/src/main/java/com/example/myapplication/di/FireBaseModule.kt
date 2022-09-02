package com.example.myapplication.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FireBaseModule {
    @Singleton
    @Provides
    fun provideAuth() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

}