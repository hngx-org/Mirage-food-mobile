package com.shegs.miragefood.ui.events

sealed interface OnboardingUiEvents {
    object NavigateToSignUp : OnboardingUiEvents
    object NavigateToSignIn : OnboardingUiEvents
    object SkipOnBoarding : OnboardingUiEvents
}