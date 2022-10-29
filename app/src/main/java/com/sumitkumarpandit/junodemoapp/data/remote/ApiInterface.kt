package com.sumitkumarpandit.junodemoapp.data.remote

import com.sumitkumarpandit.junodemoapp.data.remote.responses.ApiResponseData
import com.sumitkumarpandit.junodemoapp.network.ApiRetrofitClient
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("empty-home")
    suspend fun getEmptyState(): ApiResponseData

    @GET("home")
    suspend fun getValueState(): ApiResponseData
}