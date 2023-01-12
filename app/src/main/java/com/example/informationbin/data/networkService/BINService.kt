package com.example.informationbin.data.networkService

import com.example.informationbin.data.emptities.BinDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BINService {
    @GET("/")
    fun getBinInformation(@Query("name") bin: String): Call<BinDetail>
}