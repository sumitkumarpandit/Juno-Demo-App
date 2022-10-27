package com.sumitkumarpandit.junodemoapp

sealed class Screen(val route:String){
    object Home:Screen(route = "home_screen")
    object EmptyValues:Screen(route="empty_values_screen")
}
