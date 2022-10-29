package com.sumitkumarpandit.junodemoapp.data.remote.responses

import com.google.gson.annotations.SerializedName

data class CryptoBalance(
    @SerializedName("current_bal_in_usd") var currentBalInUSD: String,
    @SerializedName("subtitle") var subtitle : String,
    @SerializedName("title") var title : String
)