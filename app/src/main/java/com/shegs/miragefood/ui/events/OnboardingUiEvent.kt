package com.shegs.miragefood.ui.events

sealed interface OnboardingUiEvent {
    object NavigateToSignUp : OnboardingUiEvent
    object NavigateToSignIn : OnboardingUiEvent
}