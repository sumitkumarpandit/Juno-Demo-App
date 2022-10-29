package com.sumitkumarpandit.junodemoapp.network

import com.google.gson.GsonBuilder
import com.sumitkumarpandit.junodemoapp.data.remote.ApiInterface
import com.sumitkumarpandit.junodemoapp.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofitClient {

    //get retrofit instance
    companion object {

        var apiInterface: ApiInterface? = null

        fun getInstance(): ApiInterface {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Constants.BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            chain.proceed(chain.request().newBuilder().also {
                                it.addHeader("Content-Type", "application/x-www-form-urlencoded")
                            }.build())
                        }.build()
                )
                .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
                .build()

            apiInterface = retrofit.create(ApiInterface::class.java)
            return apiInterface!!
        }
    }
}