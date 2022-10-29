package com.sumitkumarpandit.junodemoapp.data.remote.responses

import com.google.gson.annotations.SerializedName

data class AllTransaction(
    @SerializedName("title") var title : String,
    @SerializedName("txn_amount") var txnAmount : String,
    @SerializedName("txn_logo") var txnLogo : String,
    @SerializedName("txn_sub_amount") var txnSubAmount : String,
    @SerializedName("txn_time") var txnTime : String,

)