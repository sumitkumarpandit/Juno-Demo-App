package com.sumitkumarpandit.junodemoapp.ui.theme

import android.hardware.lights.Light
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumitkumarpandit.junodemoapp.R
import com.sumitkumarpandit.junodemoapp.data.remote.responses.AllTransaction
import com.sumitkumarpandit.junodemoapp.util.AppGlobalData
import com.sumitkumarpandit.junodemoapp.util.convertToIntNumSys

@Composable
fun EmptyValuesScreen() {
    val state = AppGlobalData.screenState
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        Column() {
            val title = AppGlobalData.cryptoData!!.cryptoBalance.title
            val subTitle = AppGlobalData.cryptoData!!.cryptoBalance.subtitle
            val currentBal = remember {
                AppGlobalData.cryptoData!!.cryptoBalance.currentBalInUSD
            }
            CryptoAccountSection(title, subTitle, currentBal, state)
            Divider(color = LightGray, thickness = 0.5.dp)
            YourCryptoHoldings(state)
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = LightGray, thickness = 0.5.dp)
            RecentTransactions()
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = LightGray, thickness = 0.5.dp)
            CurrentPrices()
        }
    }
}

@Composable
fun CurrentPrices() {
    val cryptoPrices = remember {
        AppGlobalData.cryptoData!!.cryptoPrices
    }
    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Text(
            text = "Current Prices", fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold, modifier = Modifier
                .padding(16.dp)
        )
        LazyRow(modifier = Modifier.height(180.dp)) {
            items(items = cryptoPrices) { cryptoPrice ->
                CurrentPricesCustomItem(cryptoPrice)
            }
        }
    }
}


@Composable
fun YourCryptoHoldings(state: Boolean?) {
    val cryptoHoldingData = remember {
        AppGlobalData.cryptoData!!.yourCryptoHoldings
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Your Crypto Holdings",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier =
            Modifier
                .heightIn(0.dp, 325.dp)
                .border(0.5.dp, LightGray, RoundedCornerShape(5.dp))
        ) {
            items(items = cryptoHoldingData) { myHolding ->
                CryptoHoldingCustomItem(myHolding, state)
            }
        }
    }
}

@Composable
fun RecentTransactions() {
    val allRecentTransactions = remember {
        AppGlobalData.cryptoData!!.allTransactions
    }
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Recent Transactions", fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = "View All", fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold, color = Purple500,
                modifier = Modifier.clickable {

                }
            )
        }
        LazyColumn(modifier = Modifier.heightIn(0.dp, 235.dp)) {
            items(items = allRecentTransactions) {}
            items(items = allRecentTransactions) { transaction ->
                RecentTransactionCustomItem(transaction)
            }
        }
    }
}


@Composable
fun CryptoAccountSection(title: String, subTitle: String, currentBal: String, state: Boolean?) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .border(0.5.dp, LightGray, RoundedCornerShape(5.dp))
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.padding(start = 16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ethereum),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .offset(12.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.bitcoin),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = subTitle, color = DarkGray, fontSize = 13.sp)
            }
        }
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
        ) {
            if (state!!) {
                Box(
                    contentAlignment = Alignment.CenterEnd, modifier = Modifier
                        .border(1.dp, Purple700, RoundedCornerShape(5.dp))
                        .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 6.dp)
                ) {
                    Text(
                        text = "Deposit", color = Purple700,
                        textAlign = TextAlign.Center, fontSize = 13.sp
                    )
                }
            } else {
                TotalBalSection(currentBal)
            }
        }
    }

}

@Composable
fun TotalBalSection(currentBal: String) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "$${convertToIntNumSys(currentBal)}",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row() {
            Icon(
                painter = painterResource(id = R.drawable.ic_trend_up),
                contentDescription = "", tint = Green,
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp)
            )
            Text(
                text = "$600.33(+468%)", maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp, color = Green
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyValuesPreview() {
    EmptyValuesScreen()
}