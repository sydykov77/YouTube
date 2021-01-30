package com.example.youtube.ui.details

import androidx.lifecycle.MutableLiveData
import com.example.youtube.core.BaseViewModel
import com.example.youtube.data.network.Repository
import com.example.youtube.data.network.Status
import com.example.youtube.di.repositoryModule
import com.example.youtube.model.Playlist
import com.example.youtube.model.PlaylistItems

class DetailsPlaylistViewModel(var repository: Repository) : BaseViewModel() {

    var detailPlaylists = MutableLiveData<MutableList<PlaylistItems>>()
    var detail: MutableList<PlaylistItems>? = mutableListOf()
    var playlistId: String? = null
    fun fetchPlaylistVideo(playlistId: String?, nextPageToken: String? = null) {
        this.playlistId = playlistId
        repository.fetchDetailPlaylists(playlistId, nextPageToken).observeForever {
            when (it.status) {
                Status.SUCCESS -> getAllVideo(it?.data)
                Status.ERROR -> errorMessege.value = it.message.toString()
            }
        }
    }

    private fun getAllVideo(data: Playlist?) {
        data?.items?.let { detail?.addAll(it) }
        if (!data?.nextPageToken.isNullOrEmpty()) fetchPlaylistVideo(playlistId, data?.nextPageToken)
        else detailPlaylists.value = detail
    }
}
