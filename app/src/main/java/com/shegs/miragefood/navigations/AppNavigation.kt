package com.shegs.miragefood.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.ui.screens.GiftLunch
import com.shegs.miragefood.ui.screens.HomeScreen
import com.shegs.miragefood.ui.screens.NotificationScreen
import com.shegs.miragefood.ui.screens.OnBoardingScreen
import com.shegs.miragefood.ui.screens.RedeemLunchNotifications
import com.shegs.miragefood.ui.screens.RedeemLunchScreen
import com.shegs.miragefood.ui.screens.SearchScreen
import com.shegs.miragefood.ui.screens.SignInScreen
import com.shegs.miragefood.ui.screens.SignUpScreen
import com.shegs.miragefood.ui.screens.SplashScreen
import com.shegs.miragefood.ui.screens.WithdrawScreen
import com.shegs.miragefood.viewmodels.GiftLunchViewModel
import com.shegs.miragefood.viewmodels.OnboardingViewModel
import com.shegs.miragefood.viewmodels.RedeemLunchNotificationsViewModel
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
    redeemLunchNotificationsViewModel: RedeemLunchNotificationsViewModel,
    receivedTransaction: ReceivedTransaction,
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

        composable(NestedNavItem.SeeAllNotification.route){
            NotificationScreen()
        }

        composable(NestedNavItem.GiftLunchScreen.route){
            GiftLunch(giftLunchViewModel = giftLunchViewModel, navController)
        }

        composable(NestedNavItem.WithdrawalScreen.route){
            WithdrawScreen(navController, withdrawalViewModel)
        }

        composable(NestedNavItem.RedeemLunchScreen.route){
            RedeemLunchScreen(receivedTransaction = receivedTransaction, navController = navController) {

            }
        }

            composable(NestedNavItem.App.HomeScreen.route) {
                HomeScreen(userViewModel, transactionViewModel, navController)
            }


            composable(NestedNavItem.App.SearchScreen.route) {
                SearchScreen()
            }
            composable(NestedNavItem.App.RedeemScreen.route) {
                RedeemLunchNotifications(redeemLunchNotificationsViewModel, navController)
            }
    }
}