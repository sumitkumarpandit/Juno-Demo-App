package com.sumitkumarpandit.junodemoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.sumitkumarpandit.junodemoapp.data.remote.responses.ApiResponseData
import com.sumitkumarpandit.junodemoapp.model.MainActivityViewModel
import com.sumitkumarpandit.junodemoapp.model.ViewModelFactory
import com.sumitkumarpandit.junodemoapp.network.ApiRetrofitClient
import com.sumitkumarpandit.junodemoapp.repository.MainActivityRepository
import com.sumitkumarpandit.junodemoapp.ui.theme.JunoDemoAppTheme
import com.sumitkumarpandit.junodemoapp.util.AppGlobalData
import com.sumitkumarpandit.junodemoapp.util.Resource
import com.sumitkumarpandit.junodemoapp.util.convertToIntNumSys

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchDataFromApi()
        setContent {
            JunoDemoAppTheme {
                val navController = rememberNavController()
                NavGraph(navHostController = navController)
            }
        }
    }
// function to fetch Crypto Data from Api
    private fun fetchDataFromApi() {
        viewModel =
            ViewModelProvider(
                this,
                ViewModelFactory(MainActivityRepository(ApiRetrofitClient.getInstance()))
            )[MainActivityViewModel::class.java]
        viewModel.emptyStateResponse()
        viewModel.emptyStateResponse.observe(
            this, Observer {
                when (it) {
                    is Resource.Loading -> {
                        Log.d("Empty", "Loading...")
                    }
                    is Resource.Success -> {
                        Log.d("Empty", "Success")
                        AppGlobalData.emptyCryptoData = it.value
                    }
                    is Resource.Failure -> {
                        Log.d("Empty", "Failed")
                    }
                }
            }
        )
        viewModel.valuesStateResponse()
        viewModel.valuesStateResponse.observe(
            this, Observer {
                when (it) {
                    is Resource.Loading -> {
                        Log.d("Values", "Loading...")

                    }
                    is Resource.Success -> {
                        Log.d("Values", "Success")
                        AppGlobalData.valuesCryptoData = it.value
                    }
                    is Resource.Failure -> {
                        Log.d("Values", "Failed")
                    }
                }
            }
        )
    }
}


