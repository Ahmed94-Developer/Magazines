package com.example.myapplication.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.application.PostsApplication
import com.example.myapplication.data.adapters.PostsAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.PostsViewModel
import com.example.myapplication.viewmodel.PostsViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    val recyclerView : RecyclerView
    get() = findViewById(R.id.rv)

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory
    private lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as PostsApplication).applicationComponent.inject(this)
        postsViewModel = ViewModelProvider(this,postsViewModelFactory).get(PostsViewModel::class.java)

        postsViewModel.postsLliveData.observe(this, Observer {
            val postsAdapter = PostsAdapter(it)
            recyclerView.adapter = postsAdapter
            val linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.layoutManager = linearLayoutManager

        })
    }
}