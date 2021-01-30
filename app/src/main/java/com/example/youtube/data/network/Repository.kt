package com.example.youtube.data.network

import android.util.Log
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import java.lang.Exception


const val PART ="snippet,contentDetails"
const val KEY ="AIzaSyDr7WJvkOUCrqvY6dsVmV9hjCpxG-EYbiI"
const val CHANNEL_ID ="UCDsHatv4GJ6e4up6mCSfZTg"
class Repository(
    private var api: YoutubeApi

) {
    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val request = api.fetchPlaylist(PART,CHANNEL_ID, KEY )
            emit(Resource.success(data = request))
        }catch (e:Exception){
            emit(Resource.error(data = null,e.message?:"ERROR"))
        }

    }
    fun fetchDetailPlaylists(playlistId: String?, pageToken: String?) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val data= api.fetchDetailPlaylist(PART, KEY, playlistId, pageToken)
            emit(Resource.success(data =data))
            Log.e("olololo", "fetchDetailPlaylists: $data")
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }
}
