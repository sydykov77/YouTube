package com.example.youtube.ui.playlists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R
import com.example.youtube.model.PlaylistItems
import com.example.youtube.utils.loadImage


class PlayListAdapter(private var onItemClick: (PlaylistItems) -> Unit)
        : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

        private var list = mutableListOf<PlaylistItems>()
        lateinit var holder: ViewHolder
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.count()
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            var image: ImageView = itemView.findViewById(R.id.image)
            var title: TextView = itemView.findViewById(R.id.title)
            var desc: TextView = itemView.findViewById(R.id.description_videos)
            var amount: TextView = itemView.findViewById(R.id.amount_videos)

            fun onBind(item: PlaylistItems) {
                image.loadImage(item.snippet?.thumbnails?.medium?.url)
                title.text = item.snippet?.channelTitle
                desc.text=item.snippet?.title
                amount.text = item.contentDetails?.itemCount.toString()

            }
        }

    }