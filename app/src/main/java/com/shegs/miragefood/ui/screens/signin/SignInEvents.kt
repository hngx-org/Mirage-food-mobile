package com.shegs.miragefood.ui.screens.signin

sealed interface SignInEvents {
    object SignInClicked : SignInEvents
}