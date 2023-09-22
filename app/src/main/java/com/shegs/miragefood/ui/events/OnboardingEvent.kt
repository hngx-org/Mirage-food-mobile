package com.shegs.miragefood.ui.events

sealed interface OnboardingEvent {
    object OnSignUpClick : OnboardingEvent
    object OnSignInClick : OnboardingEvent
}