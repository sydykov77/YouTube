package com.example.youtube.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R
import com.example.youtube.model.PlaylistItems
import com.example.youtube.ui.playlists.PlayListAdapter
import com.example.youtube.utils.loadImage

    class DetailsPlaylistAdapter (private var onItemClick: (PlaylistItems) -> Unit)
    : RecyclerView.Adapter<DetailsPlaylistAdapter.DetailViewHolder>() {

    private var list = mutableListOf<PlaylistItems>()
    lateinit var holder: DetailViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_items, parent, false)
        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        this.holder = holder
        val item = list[position]
        holder.onBind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    fun addItems(items: MutableList<PlaylistItems>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: PlaylistItems) {
        list.add(item)
        notifyItemInserted(list.lastIndex)
    }

    class DetailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var title: TextView = itemView.findViewById(R.id.title)


        fun onBind(item: PlaylistItems) {
            title.text = item.snippet?.title

image.loadImage(item.snippet?.thumbnails?.medium?.url)
        }
    }

}