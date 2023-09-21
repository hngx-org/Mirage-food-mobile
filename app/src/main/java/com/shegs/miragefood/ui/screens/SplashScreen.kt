package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.R
import com.shegs.miragefood.navigations.NestedNavItem
import com.shegs.miragefood.ui.events.SplashUiEvent
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import com.shegs.miragefood.viewmodels.OnboardingViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: OnboardingViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.splashEventFlow.collectLatest { events ->
            when (events) {

                SplashUiEvent.ShowOnBoarding -> {
                    navController.navigate(NestedNavItem.Onboarding.route) {
                        popUpTo(NestedNavItem.Splash.route) {
                            inclusive = true
                        }
                    }
                }
                SplashUiEvent.SkipOnBoarding -> {
                    navController.navigate(NestedNavItem.App.HomeScreen.route) {
                        popUpTo(NestedNavItem.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "Mirage Lunch",
                    fontFamily = FontFamily(Font(R.font.poppins_black)),
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    MirageFoodTheme {
        SplashScreen(navController = NavController(LocalContext.current))
    }
}