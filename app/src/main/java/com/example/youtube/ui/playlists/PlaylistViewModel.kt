package com.example.youtube.ui.playlists

import androidx.lifecycle.MutableLiveData
import com.example.youtube.core.BaseViewModel
import com.example.youtube.data.network.Repository
import com.example.youtube.data.network.Status
import com.example.youtube.model.PlaylistItems

class PlaylistViewModel(var repository: Repository):BaseViewModel() {
    var playlists= MutableLiveData<MutableList<PlaylistItems>>()

    init {
      fetchPlaylists()
    }
  private fun fetchPlaylists(){
        repository.fetchPlaylists().observeForever{
            when(it.status){
                Status.SUCCESS -> playlists.postValue((it.data?.items))
                Status.ERROR -> errorMessege.postValue(it.message.toString())
            }
        }
    }
}