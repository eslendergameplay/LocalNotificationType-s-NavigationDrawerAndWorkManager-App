package com.example.jetpack19.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack19.views.AboutView
import com.example.jetpack19.views.AccountView
import com.example.jetpack19.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navC = navController)
        }
        composable("About"){
            AboutView(navController)
        }
        composable("Account"){
            AccountView(navController)
        }
    }
}