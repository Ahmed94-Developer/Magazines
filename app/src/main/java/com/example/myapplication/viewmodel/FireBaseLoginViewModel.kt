package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.FireBaseLoginRepository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch
import javax.inject.Inject

class FireBaseLoginViewModel @Inject constructor(val fireBaseLoginRepository: FireBaseLoginRepository) :ViewModel() {

    val firebaseUserLiveData : LiveData<Task<AuthResult>> get() = fireBaseLoginRepository.firebaseLiveData


  fun setlogin(email : String,passWord : String){
      viewModelScope.launch {
          fireBaseLoginRepository.setLogin(email, passWord)
      }

  }

}