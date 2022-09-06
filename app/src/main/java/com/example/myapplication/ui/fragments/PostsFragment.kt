package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.application.PostsApplication
import com.example.myapplication.data.adapters.PostsAdapter
import com.example.myapplication.viewmodel.PostsViewModel
import com.example.myapplication.viewmodel.PostsViewModelFactory
import javax.inject.Inject


class PostsFragment : Fragment() {

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory
    private lateinit var postsViewModel: PostsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_posts, container, false)

        val recyclerView : RecyclerView = view.findViewById(R.id.recycler_view)

        (requireActivity().application as PostsApplication).applicationComponent.inject(this)
        postsViewModel = ViewModelProvider(this,postsViewModelFactory).get(PostsViewModel::class.java)

        postsViewModel.postsLliveData.observe(requireActivity(), Observer {
            val postsAdapter = PostsAdapter(it)
            recyclerView.adapter = postsAdapter
            val linearLayoutManager : LinearLayoutManager = LinearLayoutManager(requireActivity())
            recyclerView.layoutManager = linearLayoutManager

        })

        return view
    }


}