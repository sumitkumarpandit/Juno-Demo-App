package com.sumitkumarpandit.junodemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.sumitkumarpandit.junodemoapp.ui.theme.JunoDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JunoDemoAppTheme {
                val navController = rememberNavController()
                NavGraph(navHostController = navController)
            }
        }
    }
}


