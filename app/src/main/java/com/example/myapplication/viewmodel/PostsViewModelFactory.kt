package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repository.PostsRepository

import javax.inject.Inject

class PostsViewModelFactory @Inject constructor(val postsRepository: PostsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(postsRepository) as T
    }
}