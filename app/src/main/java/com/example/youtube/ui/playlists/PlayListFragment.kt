package com.example.youtube.ui.playlists

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_list.*
import com.example.youtube.R
import com.example.youtube.model.PlaylistItems
import org.koin.android.ext.android.inject


class PlayListFragment : Fragment() {

    private val viewModel by inject<PlaylistViewModel>()

    lateinit var adapter: PlayListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observer()

    }

    private fun initRecycler() {
        adapter = PlayListAdapter(this::onItemClick)
        list_recycler_view.adapter = adapter
    }


    private fun onItemClick(item: PlaylistItems) {
        findNavController().navigate(
            R.id.detailsPlaylistFragment,
            Bundle().also { it.putSerializable("ZZZ",item.id) }
        )

    }

    private fun observer() {
        viewModel.playlists.observeForever {
            adapter.addItems(it)
            Log.e("ololo", "observer: $it")
        }
    }


}