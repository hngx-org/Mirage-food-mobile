package com.shegs.miragefood.ui.screens.signin

data class SignInFormState(
    val email: String ="",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null
)
