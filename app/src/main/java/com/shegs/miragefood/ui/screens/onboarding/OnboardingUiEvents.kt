package com.shegs.miragefood.ui.screens.onboarding

sealed interface OnboardingUiEvents {
    object NavigateToSignUp : OnboardingUiEvents
    object NavigateToSignIn : OnboardingUiEvents
    object SkipOnBoarding : OnboardingUiEvents
}