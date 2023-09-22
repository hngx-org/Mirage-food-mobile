package com.shegs.miragefood.ui.events

sealed interface SplashUiEvent {
    object ShowOnBoarding : SplashUiEvent
    object SkipOnBoarding : SplashUiEvent
}