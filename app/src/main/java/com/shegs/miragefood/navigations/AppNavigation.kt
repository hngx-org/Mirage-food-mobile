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
import androidx.navigation.navigation
import com.shegs.miragefood.ui.screens.HomeScreen
import com.shegs.miragefood.ui.screens.SearchScreen
import com.shegs.miragefood.ui.screens.onboarding.OnboardingScreen
import com.shegs.miragefood.ui.screens.signin.SignInScreen
import com.shegs.miragefood.ui.screens.signup.SignUpScreen
import com.shegs.miragefood.viewmodels.SearchViewModel
import com.shegs.miragefood.viewmodels.TransactionViewModel
import com.shegs.miragefood.viewmodels.UserViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel,
    viewModel: TransactionViewModel,
    searchViewModel: SearchViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NestedNavItem.Onboarding.route,
        modifier = modifier
    ) {

        composable(NestedNavItem.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }

        composable(NestedNavItem.SignUpScreen.route) {
            SignUpScreen()
        }

        composable(NestedNavItem.SignInScreen.route) {
            SignInScreen()
        }

        navigation(
            route = NestedNavItem.App.route,
            startDestination = NestedNavItem.App.HomeScreen.route
        ) {
            composable(NestedNavItem.App.HomeScreen.route) {
                HomeScreen(
                    userViewModel = userViewModel,
                    viewModel = viewModel
                )
            }
            composable(NestedNavItem.App.SearchScreen.route) {
                SearchScreen(searchViewModel = searchViewModel)
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
}