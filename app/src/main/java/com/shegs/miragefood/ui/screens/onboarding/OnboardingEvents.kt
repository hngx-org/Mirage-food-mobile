package com.shegs.miragefood.ui.screens.onboarding

sealed interface OnboardingEvents {
    object OnSignUpClick : OnboardingEvents
    object OnSignInClick : OnboardingEvents
}