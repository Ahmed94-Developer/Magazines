package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.myapplication.R
import com.example.myapplication.application.PostsApplication
import com.example.myapplication.viewmodel.FireBaseLoginViewModel
import com.example.myapplication.viewmodel.ViewModelFactory
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var fireBaseLoginViewModel: FireBaseLoginViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val mailTxt: EditText
    get() = findViewById(R.id.mail_txt)

    val password_txt: EditText
    get() = findViewById(R.id.password_txt)

    val btnLogin: Button
    get() = findViewById(R.id.btn_login)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as PostsApplication).applicationComponent.inject(this)

        fireBaseLoginViewModel =
            ViewModelProvider(this, viewModelFactory).get(FireBaseLoginViewModel::class.java)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val mail = mailTxt.text.toString()
        val passWord = password_txt.text.toString()

        fireBaseLoginViewModel.setlogin(mail, passWord)
        fireBaseLoginViewModel.firebaseUserLiveData.observe(this, Observer<Task<AuthResult>> {
            if (it.isSuccessful) {
                Toast.makeText(this@LoginActivity, "User Login Successfully", Toast.LENGTH_LONG)
                    .show()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            } else {
                Toast.makeText(this@LoginActivity, it.exception!!.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}