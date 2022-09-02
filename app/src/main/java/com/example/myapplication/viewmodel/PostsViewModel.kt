package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.PostsRepository
import com.example.myapplication.retrofit.model.Posts
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostsViewModel @Inject constructor(val postsRepository: PostsRepository) : ViewModel() {
    val postsLliveData : LiveData<List<Posts>> get() = postsRepository.postsLiveData

    init {
        viewModelScope.launch {
            postsRepository.getPosts()
        }

    }
}