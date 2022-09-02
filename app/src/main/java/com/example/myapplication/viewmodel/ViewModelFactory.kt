package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repository.FireBaseLoginRepository

import javax.inject.Inject

class ViewModelFactory @Inject constructor(val fireBaseLoginRepository: FireBaseLoginRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FireBaseLoginViewModel(fireBaseLoginRepository) as T
    }

}