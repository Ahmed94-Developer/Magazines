package com.example.myapplication.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

 class FireBaseLoginRepository @Inject constructor(val mAuth: FirebaseAuth) {

    val firebaseUserMutableliveData = MutableLiveData<Task<AuthResult>>()
    val firebaseLiveData : LiveData<Task<AuthResult>> get() = firebaseUserMutableliveData
     val application: Application = Application()

  fun setLogin(email : String,passWord: String){

      mAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(
                OnCompleteListener {
                    firebaseUserMutableliveData.postValue(it)
                }

            )

    }
}