package com.shegs.miragefood.ui.screens.signup

sealed interface SignUpFormEvent {
    data class FullNameChanged(val fullName: String) : SignUpFormEvent
    data class EmailChanged(val email: String) : SignUpFormEvent
    data class PasswordChanged(val password: String) : SignUpFormEvent
    data class RepeatedPasswordChanged(val repeatedPassword: String) : SignUpFormEvent
    data class RememberPassword(val rememberPassword: Boolean) : SignUpFormEvent
    object OnSignUpClicked : SignUpFormEvent
}