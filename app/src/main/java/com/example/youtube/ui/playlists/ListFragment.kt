package com.example.youtube.ui.playlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.*
import com.example.youtube.R


class ListFragment : Fragment() {

    lateinit var adapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

    }

    private fun initRecycler() {
        adapter = ListAdapter()
        list_recycler_view.adapter = adapter
        setData()
    }

    private fun setData() {
        for (i in 1..10){
            adapter.add("data: $i")
        }
        adapter.notifyDataSetChanged()
    }
}