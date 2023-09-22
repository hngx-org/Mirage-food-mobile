package com.shegs.miragefood.navigations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shegs.miragefood.ui.screens.GiftLunch
import com.shegs.miragefood.ui.screens.HomeScreen
import com.shegs.miragefood.ui.screens.OnBoardingScreen
import com.shegs.miragefood.ui.screens.SignInScreen
import com.shegs.miragefood.ui.screens.SignUpScreen
import com.shegs.miragefood.ui.screens.SplashScreen
import com.shegs.miragefood.ui.screens.WithdrawScreen
import com.shegs.miragefood.viewmodels.GiftLunchViewModel
import com.shegs.miragefood.viewmodels.OnboardingViewModel
import com.shegs.miragefood.viewmodels.TransactionViewModel
import com.shegs.miragefood.viewmodels.UserViewModel
import com.shegs.miragefood.viewmodels.WithdrawalViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    userViewModel: UserViewModel,
    transactionViewModel: TransactionViewModel,
    onboardingViewModel: OnboardingViewModel,
    withdrawalViewModel: WithdrawalViewModel,
    giftLunchViewModel: GiftLunchViewModel,
    modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NestedNavItem.SplashScreen.route,
        modifier = modifier
    ) {

        composable(NestedNavItem.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(NestedNavItem.Onboarding.route) {
            val onboardingViewModel: OnboardingViewModel = hiltViewModel()
            OnBoardingScreen(navController = navController, onboardingViewModel = onboardingViewModel, onEvent = onboardingViewModel::onEvent)
        }

        composable(NestedNavItem.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(NestedNavItem.SignInScreen.route) {
            SignInScreen(navController)
        }
        composable(NestedNavItem.GiftLunchScreen.route){
            GiftLunch(giftLunchViewModel = giftLunchViewModel, navController)
        }

        composable(NestedNavItem.WithdrawalScreen.route){
            WithdrawScreen(navController, withdrawalViewModel)
        }

            composable(NestedNavItem.App.HomeScreen.route) {
                HomeScreen(userViewModel, transactionViewModel, navController)
            }


            composable(NestedNavItem.App.SearchScreen.route) {
                //TODO() replace with the search screen
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = NestedNavItem.App.SearchScreen.label!!)
                }
            }
            composable(NestedNavItem.App.RedeemScreen.route) {
                //TODO() replace with the redeem screen
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = NestedNavItem.App.RedeemScreen.label!!)
                }
            }
    }
}