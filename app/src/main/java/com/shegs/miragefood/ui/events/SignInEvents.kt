package com.shegs.miragefood.ui.events

sealed interface SignInEvents {
    object SignInClicked : SignInEvents
}