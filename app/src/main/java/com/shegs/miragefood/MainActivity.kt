package com.shegs.miragefood

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.navigations.BottomNavBar
import com.shegs.miragefood.navigations.Navigation
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import com.shegs.miragefood.viewmodels.GiftLunchViewModel
import com.shegs.miragefood.viewmodels.LunchViewModel
import com.shegs.miragefood.viewmodels.OnboardingViewModel
import com.shegs.miragefood.viewmodels.RedeemLunchNotificationsViewModel
import com.shegs.miragefood.viewmodels.SignInViewModel
import com.shegs.miragefood.viewmodels.TransactionViewModel
import com.shegs.miragefood.viewmodels.UserViewModel
import com.shegs.miragefood.viewmodels.WithdrawalViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userViewModel: UserViewModel

    @Inject
    lateinit var signInViewModel: SignInViewModel

    @Inject
    lateinit var redeemLunchNotificationsViewModel: RedeemLunchNotificationsViewModel

    @Inject
    lateinit var lunchViewModel: LunchViewModel

    // Initialize the ViewModel
    private val onBoardingViewModel: OnboardingViewModel by viewModels()

    private val giftLunchViewModel: GiftLunchViewModel by viewModels()

    private val withdrawalViewModel: WithdrawalViewModel by viewModels()


    private var receivedTransaction: ReceivedTransaction = ReceivedTransaction(
        amountSent = 2, // Provide the appropriate default value
        message = "Thank you for helping me out with my task in HNG",  // Provide the appropriate default value
        sender = "Shegs",   // Provide the appropriate default value
        timestamp = System.currentTimeMillis() // Provide the appropriate default value
    )

    @Inject
    lateinit var transactionViewModel: TransactionViewModel

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
                        Navigation(
                            navController,
                            userViewModel,
                            transactionViewModel,
                            onBoardingViewModel,
                            lunchViewModel,
                            withdrawalViewModel,
                            giftLunchViewModel,
                            redeemLunchNotificationsViewModel,
                            receivedTransaction,
                            signInViewModel,
                        )
                    }

                }
            }
        }
    }
}

