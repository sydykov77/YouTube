package com.example.youtube.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://www.googleapis.com/"


private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
    .connectTimeout(40, TimeUnit.SECONDS)
    .readTimeout(40, TimeUnit.SECONDS)
    .writeTimeout(40, TimeUnit.SECONDS)
    .addInterceptor(httpLoggingInterceptor)
    .build()

private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()


fun provideYoutubeApi(): YoutubeApi {
    return retrofit.create(YoutubeApi::class.java)
}

