package com.sumitkumarpandit.junodemoapp.data.remote.responses

import com.google.gson.annotations.SerializedName

data class CryptoPrice(
    @SerializedName("current_price_in_usd") var currentPriceInUSD : String,
    @SerializedName("logo") var logo : String,
    @SerializedName("title") var title : String
)