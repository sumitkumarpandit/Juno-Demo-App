package com.sumitkumarpandit.junodemoapp.data.remote.responses

import com.google.gson.annotations.SerializedName

data class YourCryptoHolding(
    @SerializedName("current_bal_in_token") var currentBalInToken : String,
    @SerializedName("current_bal_in_usd") var currentBalInUSD : String,
    @SerializedName("logo") var logo : String,
    @SerializedName("title") var title : String,
)