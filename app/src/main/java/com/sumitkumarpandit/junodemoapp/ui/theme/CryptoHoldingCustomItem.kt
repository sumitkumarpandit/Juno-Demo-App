package com.sumitkumarpandit.junodemoapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.sumitkumarpandit.junodemoapp.R
import com.sumitkumarpandit.junodemoapp.data.remote.responses.YourCryptoHolding
import com.sumitkumarpandit.junodemoapp.util.convertToIntNumSys

@Composable
fun CryptoHoldingCustomItem(cryptoHoldingData: YourCryptoHolding, state: Boolean?) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .decoderFactory(SvgDecoder.Factory())
                        .data(cryptoHoldingData.logo)
                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                        .build()
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = cryptoHoldingData.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = if (state!!) "" else cryptoHoldingData.currentBalInToken,
                        color = DarkGray,
                        fontSize = 13.sp
                    )
                }
            }
            if (state!!)
                CryptoHoldingEmptySection()
            else
                CryptoHoldingValuesSection(cryptoHoldingData.currentBalInUSD)
        }
        Divider(color = LightGray, thickness = 0.5.dp)
    }

}

@Composable
fun CryptoHoldingValuesSection(currentBal: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End, modifier = Modifier.padding(16.dp)
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
                text = "$600.33(+468%)",
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp, color = Green
            )
        }
    }
}

@Composable
fun CryptoHoldingEmptySection() {
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .border(1.dp, Purple700, RoundedCornerShape(5.dp))
        ) {
            Text(
                text = "Deposit",
                fontSize = 13.sp,
                color = Purple700,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 6.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Purple700)
        ) {
            Text(
                text = "Buy", fontSize = 13.sp, color = White, textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 6.dp, bottom = 6.dp)
            )
        }
    }
}

