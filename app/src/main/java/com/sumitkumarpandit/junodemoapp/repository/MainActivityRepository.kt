package com.sumitkumarpandit.junodemoapp.repository

import com.sumitkumarpandit.junodemoapp.data.remote.ApiInterface

class MainActivityRepository(private val apiInterface: ApiInterface):BaseRepository() {
    suspend fun emptyStateApi()=
        safeApiCall {
           apiInterface.getEmptyState()
        }

    suspend fun valueStateApi()=
        safeApiCall {
            apiInterface.getValueState()
        }
}