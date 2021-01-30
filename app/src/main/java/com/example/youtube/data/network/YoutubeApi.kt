package com.example.youtube.data.network


import com.example.youtube.model.Playlist
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("youtube/v3/playlists")
    suspend fun fetchPlaylist(
        @Query("part")part: String,
        @Query("channelId")channelId: String,
        @Query("key")key: String,
        ): Playlist

    @GET("youtube/v3/playlistItems")
    suspend fun fetchDetailPlaylist(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("playlistId") playlistId: String?,
        @Query("pageToken") pageToken: String?
    ): Playlist
}