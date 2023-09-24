package com.shegs.miragefood.ui.events

sealed interface SignInUiEvents {
    object OnsuccessfulSignIn : SignInUiEvents
    data class ShowSnackBar(val message: String) : SignInUiEvents
}