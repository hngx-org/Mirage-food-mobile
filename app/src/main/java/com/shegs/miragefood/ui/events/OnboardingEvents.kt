package com.shegs.miragefood.ui.events

sealed interface OnboardingEvents {
    object OnSignUpClick : OnboardingEvents
    object OnSignInClick : OnboardingEvents
}