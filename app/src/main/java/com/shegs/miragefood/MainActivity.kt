package com.shegs.miragefood

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.shegs.miragefood.navigations.BottomNavBar
import com.shegs.miragefood.navigations.Navigation
import com.shegs.miragefood.ui.theme.MirageFoodTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()


            class MainActivity : ComponentActivity() {
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContent {
                        MirageFoodTheme {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                Scaffold(
                                    bottomBar = {
                                        BottomNavBar(navController = navController)
                                    }
                                ) {
                                    Navigation(navController = navController)

                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

