package com.shegs.miragefood.ui.screens.signin

sealed interface SignInFormEvent {

    data class EmailChanged(val email: String) : SignInFormEvent
    data class PasswordChanged(val password: String) : SignInFormEvent
    object SignInClicked : SignInFormEvent
}