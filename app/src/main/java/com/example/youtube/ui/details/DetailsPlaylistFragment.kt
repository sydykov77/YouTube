package com.example.youtube.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.youtube.R
import com.example.youtube.model.PlaylistItems
import kotlinx.android.synthetic.main.content_scrolling.*
import org.koin.android.ext.android.inject

class DetailsPlaylistFragment : Fragment() {
    private val viewModel by inject<DetailsPlaylistViewModel>()

    lateinit var adapter: DetailsPlaylistAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_playlist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecView()
        val id =arguments?.getString("ZZZ")
        Log.e("ololo", "onViewCreated: $id", )
        observer()
        fetchDetailPlayList(id.toString())
    }

    private fun fetchDetailPlayList(s: String) {
        viewModel.fetchPlaylistVideo(s)
    }

    private fun observer() {
        viewModel.detailPlaylists.observeForever{
            adapter.addItems(it)
            Log.e("ololo", "observer: $it")
        }
    }

    fun initRecView(){
        adapter = DetailsPlaylistAdapter(this::onItemClick)
        playListsInfoFragment_recyclerview.adapter = adapter
    }

    private fun onItemClick(item:PlaylistItems) {

    }

}