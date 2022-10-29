package com.sumitkumarpandit.junodemoapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.sumitkumarpandit.junodemoapp.R
import com.sumitkumarpandit.junodemoapp.data.remote.responses.AllTransaction
import com.sumitkumarpandit.junodemoapp.data.remote.responses.CryptoPrice
import com.sumitkumarpandit.junodemoapp.util.AppGlobalData
import com.sumitkumarpandit.junodemoapp.util.convertToIntNumSys

@Composable
fun CurrentPricesCustomItem(cryptoPrice: CryptoPrice) {
    Box(
        contentAlignment = Alignment.TopEnd, modifier = Modifier
            .size(180.dp, 180.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .border(0.5.dp, LightGray, RoundedCornerShape(5.dp))
                .fillMaxSize()
        ) {
            CurrentPricesData(cryptoPrice)
        }
        Row() {
            Box(
                modifier = Modifier
                    .border(1.dp, Purple700, RoundedCornerShape(5.dp))
                    .background(White)
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_download), tint = Purple500,
                    contentDescription = null,
                    modifier = Modifier
                        .size(14.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .border(1.dp, Purple700, RoundedCornerShape(5.dp))
                    .background(White)
                    .clickable {
                        buySelectedCrypto(cryptoPrice)
                    }
            ) {
                Text(
                    text = "Buy", fontSize = 10.sp, color = Purple500, textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }

}

fun buySelectedCrypto(cryptoPrice: CryptoPrice) {
    val bal = AppGlobalData.cryptoData!!.cryptoBalance.currentBalInUSD
    AppGlobalData.cryptoData!!.cryptoBalance.currentBalInUSD = "0.00"
    AppGlobalData.cryptoData!!.allTransactions.add(
        AllTransaction(
            "${cryptoPrice.title} Bought",
            bal,
            cryptoPrice.logo,"Buy Price: $${convertToIntNumSys(cryptoPrice.currentPriceInUSD)}","1 min ago"
        )
    )
}

@Composable
fun CurrentPricesData(cryptoPrice: CryptoPrice) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 16.dp)
            .fillMaxSize()
    ) {
        Row(
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .decoderFactory(SvgDecoder.Factory())
                    .data(cryptoPrice.logo)
                    .size(Size.ORIGINAL) // Set the target size to load the image at.
                    .build()
            )
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier
                    .size(54.dp)
            )
        }
        Text(
            text = cryptoPrice.title,
            fontSize = 14.sp,
            color = DarkGray,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "$${convertToIntNumSys(cryptoPrice.currentPriceInUSD)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_trend_down), contentDescription = null,
                tint = Red, modifier = Modifier
                    .size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "7.22%", fontSize = 10.sp, color = Red)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "24h", fontSize = 10.sp, color = DarkGray)
        }
    }
}
