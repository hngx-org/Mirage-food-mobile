package com.shegs.miragefood.ui.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.navigations.NestedNavItem
import com.shegs.miragefood.ui.screens.common.CustomRoundedButton
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun OnboardingScreen(
    navController: NavController,
    viewModel: OnBoardingViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.uiEventFlow.collectLatest { event ->
            when (event) {
                OnboardingUiEvents.NavigateToSignIn -> {
                    navController.navigate(NestedNavItem.SignInScreen.route)
                }

                OnboardingUiEvents.NavigateToSignUp -> {
                    navController.navigate(NestedNavItem.SignUpScreen.route)
                }

                OnboardingUiEvents.SkipOnBoarding -> {
                    navController.navigate(NestedNavItem.App.route) {
                        popUpTo(NestedNavItem.Onboarding.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }

    OnboardingScreenContent(state = state, onEvent = viewModel::onEvent)
}

@Composable
fun OnboardingScreenContent(
    state: OnboardingState,
    onEvent: (OnboardingEvents) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = state.showOptions) {
            Column {
                CustomRoundedButton(
                    label = "Sign Up",
                    modifier = Modifier.fillMaxWidth(0.9f),
                    filled = true,
                    onClick = { onEvent(OnboardingEvents.OnSignUpClick) }
                )
                Spacer(modifier = Modifier.height(12.dp))
                CustomRoundedButton(
                    label = "Sign In",
                    modifier = Modifier.fillMaxWidth(0.9f),
                    onClick = { onEvent(OnboardingEvents.OnSignInClick) })

            }
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    MirageFoodTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            OnboardingScreenContent(state = OnboardingState(), onEvent = {})
        }
    }
}