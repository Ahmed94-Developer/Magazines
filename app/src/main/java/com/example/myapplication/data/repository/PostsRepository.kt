package com.example.myapplication.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.retrofit.api.DataApi
import com.example.myapplication.retrofit.model.Posts
import javax.inject.Inject

class PostsRepository @Inject constructor(private val dataApi: DataApi){
    val postsMutableLiveData : MutableLiveData<List<Posts>> = MutableLiveData()
    val postsLiveData : LiveData<List<Posts>> get() = postsMutableLiveData

    suspend fun getPosts(){
        val result = dataApi.getPosts()
        if (result.isSuccessful && result.body() != null){
            postsMutableLiveData.postValue(result.body())
        }
    }
}