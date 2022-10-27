package com.sumitkumarpandit.junodemoapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun EmptyValuesScreen(name:String){
Column(modifier = Modifier.fillMaxSize()) {
    Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
}
}

@Preview(showBackground = true)
@Composable
fun EmptyValuesPreview() {
        EmptyValuesScreen("hello")
}