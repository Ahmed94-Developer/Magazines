package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.data.adapters.PagerAdapter
import com.example.myapplication.viewmodel.PostsViewModelFactory
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    val viewPager: ViewPager
    get() = findViewById(R.id.view_pager)

    val tabLayout : TabLayout get() = findViewById(R.id.tabLayout)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       viewPager.adapter = PagerAdapter(supportFragmentManager)
       tabLayout.setupWithViewPager(viewPager)
       tabLayout.getTabAt(0)!!.setText(R.string.Articles);
       tabLayout.getTabAt(1)!!.setText(R.string.locations);


    }
}