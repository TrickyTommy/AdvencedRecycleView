package com.example.adnvancedrecycleview.clients

import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkProvider {
    private const val BASE_URL="https://randomuser.me/"


    fun providesHttpAdapter(): Retrofit{
        return Retrofit.Builder().apply {
            client(providesHttpClients())
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    private fun providesHttpClients(): OkHttpClient{
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(providesHttpLoggingInterceptor())
        }.build()
    }

    private fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG) {
                true -> Level.BODY
                false -> Level.NONE
            }
        }

    }
}