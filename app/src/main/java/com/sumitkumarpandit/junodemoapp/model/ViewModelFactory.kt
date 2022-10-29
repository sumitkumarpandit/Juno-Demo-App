package com.sumitkumarpandit.junodemoapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sumitkumarpandit.junodemoapp.repository.BaseRepository
import com.sumitkumarpandit.junodemoapp.repository.MainActivityRepository

class ViewModelFactory(private val repository:BaseRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> MainActivityViewModel(
                repository as MainActivityRepository
            ) as T
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}