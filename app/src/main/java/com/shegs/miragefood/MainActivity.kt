package com.shegs.miragefood

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.navigations.AppNavigation
import com.shegs.miragefood.navigations.BottomNavBar
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var receivedTransaction: ReceivedTransaction = ReceivedTransaction(
        amountSent = 2, // Provide the appropriate default value
        message = "Thank you for helping me out with my task in HNG",  // Provide the appropriate default value
        sender = "Shegs",   // Provide the appropriate default value
        timestamp = System.currentTimeMillis() // Provide the appropriate default value
    )

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MirageFoodTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(navController = navController)
                        }
                    ) { innerPadding ->
                        AppNavigation(navController, receivedTransaction)
                    }

                }
            }
        }
    }
}

