package com.example.myapplication.data.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.ui.fragments.MapsFragment
import com.example.myapplication.ui.fragments.PostsFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                return PostsFragment()
            }
            1 -> {
                return MapsFragment()
            }
        }
        return PostsFragment()
    }



}
