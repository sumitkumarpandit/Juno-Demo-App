package com.sumitkumarpandit.junodemoapp

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sumitkumarpandit.junodemoapp.ui.theme.EmptyValuesScreen
import com.sumitkumarpandit.junodemoapp.ui.theme.HomeScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navHostController)
        }
        composable(route = Screen.EmptyValues.route) {
            EmptyValuesScreen(name = "Empty")
        }
    }
}