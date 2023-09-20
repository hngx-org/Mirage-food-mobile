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
import com.shegs.miragefood.navigations.BottomNavBar
import com.shegs.miragefood.navigations.Navigation
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import com.shegs.miragefood.viewmodels.TransactionViewModel
import com.shegs.miragefood.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userViewModel: UserViewModel

    @Inject
    lateinit var viewModel: TransactionViewModel

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
                    ) {  innerPadding ->
                        Navigation(navController = navController, userViewModel = userViewModel, viewModel = viewModel)
                    }

                }
            }
        }
    }
}

