package com.sumitkumarpandit.junodemoapp.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ApiResponseData(
    @SerializedName("all_transactions") var allTransactions : ArrayList<AllTransaction>,
    @SerializedName("crypto_balance") var cryptoBalance : CryptoBalance,
    @SerializedName("crypto_prices") var cryptoPrices : ArrayList<CryptoPrice>,
    @SerializedName("your_crypto_holdings") var yourCryptoHoldings : ArrayList<YourCryptoHolding>
)