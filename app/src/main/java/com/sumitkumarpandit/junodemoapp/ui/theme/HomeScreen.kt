package com.sumitkumarpandit.junodemoapp.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumitkumarpandit.junodemoapp.Screen
import com.sumitkumarpandit.junodemoapp.util.AppGlobalData

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CreateButton(buttonText = "Empty", navHostController = navHostController, SkyBlue, true)
        Spacer(modifier = Modifier.height(64.dp))
        CreateButton(buttonText = "Values", navHostController = navHostController, Orange, false)
    }
}

@Composable
fun CreateButton(
    buttonText: String,
    navHostController: NavHostController,
    color: Color,
    state: Boolean
) {
    val context = LocalContext.current
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        onClick = {
            AppGlobalData.screenState = state
            AppGlobalData.cryptoData = if (state) AppGlobalData.emptyCryptoData
            else AppGlobalData.valuesCryptoData
            if (AppGlobalData.cryptoData == null)
                Toast.makeText(context, "No crypto data available", Toast.LENGTH_SHORT).show()
            else
                navHostController.navigate(route = Screen.EmptyValues.route)
        },
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
    ) {
        Text(
            text = buttonText,
            fontSize = 18.sp, color = White,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)


        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())
}