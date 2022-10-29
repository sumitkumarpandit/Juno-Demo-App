package com.sumitkumarpandit.junodemoapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumitkumarpandit.junodemoapp.data.remote.responses.ApiResponseData
import com.sumitkumarpandit.junodemoapp.repository.MainActivityRepository
import com.sumitkumarpandit.junodemoapp.util.Resource
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: MainActivityRepository):ViewModel(){
    private val _emptyStateResponse: MutableLiveData<Resource<ApiResponseData>> =
        MutableLiveData()
    val emptyStateResponse: LiveData<Resource<ApiResponseData>>
        get() = _emptyStateResponse

    fun emptyStateResponse() = viewModelScope.launch {
            _emptyStateResponse.value = Resource.Loading
             _emptyStateResponse.value = repository.emptyStateApi()
    }

    private val _valuesStateResponse: MutableLiveData<Resource<ApiResponseData>> =
        MutableLiveData()
    val valuesStateResponse: LiveData<Resource<ApiResponseData>>
        get() = _valuesStateResponse

    fun valuesStateResponse() = viewModelScope.launch {
        _valuesStateResponse.value = Resource.Loading
        _valuesStateResponse.value = repository.valueStateApi()
    }
}