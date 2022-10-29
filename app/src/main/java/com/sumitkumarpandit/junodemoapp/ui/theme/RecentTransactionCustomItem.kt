package com.sumitkumarpandit.junodemoapp.ui.theme

import androidx.compose.foundation.Image
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
import com.sumitkumarpandit.junodemoapp.util.convertToIntNumSys

@Composable
fun RecentTransactionCustomItem(transaction:AllTransaction){
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .decoderFactory(SvgDecoder.Factory())
                        .data(transaction.txnLogo)
                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                        .build()
                )
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = transaction.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(text = transaction.txnTime, color = DarkGray, fontSize = 13.sp)
                }
            }
                RecentTransactionValuesSection(transaction)
        }
    }
}

@Composable
fun RecentTransactionValuesSection(transaction:AllTransaction){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End, modifier = Modifier.padding(16.dp)
    ) {
        val title = transaction.title
        val subAmount = transaction.txnSubAmount
        val amount = transaction.txnAmount
        if(title.contains("Bought")) {
            Text(
                text = "$$amount",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp, textAlign = TextAlign.End
            )
        }
        else if(title.contains("Withdrawn")){
            Text(
                text = "-$$amount",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp, textAlign = TextAlign.End,color = Red
            )
        }
        else{
            Text(
                text = "+$${convertToIntNumSys(amount)}",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp, textAlign = TextAlign.End,color = Green
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
            Text(text = subAmount,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp, color = DarkGray, textAlign = TextAlign.End
            )
    }
}
@Preview(showBackground = true)
@Composable
fun RecentTransactionCustomItemPreview() {
    RecentTransactionCustomItem(AllTransaction("","","","",""))
}
