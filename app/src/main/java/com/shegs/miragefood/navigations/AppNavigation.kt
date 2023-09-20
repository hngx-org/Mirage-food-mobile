package com.shegs.miragefood.navigations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shegs.miragefood.models.datas.BottomNavItems

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Home.route
    ) {
        composable(BottomNavItems.Home.route) {


        }
        composable(BottomNavItems.Search.route) {
            //TODO() replace with the search screen
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = BottomNavItems.Search.label)
            }
        }
        composable(BottomNavItems.Notifications.route) {
            //TODO() replace with the notifications screen
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = BottomNavItems.Notifications.label)
            }
        }
        composable(BottomNavItems.Settings.route) {
            //TODO() replace with the settings screen
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = BottomNavItems.Settings.label)
            }
        }
    }
}