package com.example.myapplication.retrofit.api

import com.example.myapplication.retrofit.model.Posts
import retrofit2.Response
import retrofit2.http.GET

interface DataApi {
    @GET("posts")
    suspend fun getPosts() : Response<List<Posts>>
}