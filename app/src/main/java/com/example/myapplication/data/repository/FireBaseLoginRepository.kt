package com.example.myapplication.data.repository

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

 class FireBaseLoginRepository @Inject constructor(val mAuth: FirebaseAuth,val context: Context) {

    val firebaseUserMutableliveData = MutableLiveData<Task<AuthResult>>()
    val firebaseLiveData : LiveData<Task<AuthResult>> get() = firebaseUserMutableliveData


  fun setLogin(email : String,passWord: String){
   if (TextUtils.isEmpty(email) || TextUtils.isEmpty(passWord)){
       Toast.makeText(context,"Some Fields are Required",Toast.LENGTH_LONG).show()
   }else{
       mAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(
           OnCompleteListener {
               firebaseUserMutableliveData.postValue(it)
           }

       )
   }


    }
}