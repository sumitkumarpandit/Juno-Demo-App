package com.sumitkumarpandit.junodemoapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumitkumarpandit.junodemoapp.Screen

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CreateButton(buttonText = "Empty", navHostController = navHostController)
        Spacer(modifier = Modifier.height(64.dp))
        CreateButton(buttonText = "Values", navHostController = navHostController)
    }
}
@Composable
fun CreateButton(buttonText: String, navHostController: NavHostController) {
    Button(
        onClick = { navHostController.navigate(Screen.EmptyValues.route)
        },
        modifier = Modifier.clip(RoundedCornerShape(20.dp))
    ) {
        Text(
            text = buttonText,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(8.dp)


        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())
}