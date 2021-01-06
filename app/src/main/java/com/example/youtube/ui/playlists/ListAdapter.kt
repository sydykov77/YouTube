package com.example.youtube.ui.playlists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R

class ListAdapter : RecyclerView.Adapter<ListAdapter.PlaylistViewHolder>() {

    var list = ArrayList<String>()

    fun add(data:String){
        list.add(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder
            = PlaylistViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false))

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        //holder.onBind()
    }

    override fun getItemCount(): Int  = list.size

    class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}