package com.example.adnvancedrecycleview.services

import com.example.adnvancedrecycleview.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDataSource{
    @GET("api")
    fun discoverUser(
        @Query("results") results: Int = 50
//        apiKey: String = BuildConfig.API_KEY
//        @Query("inc") inc: String=""
    ):Call<ResponseData>
}