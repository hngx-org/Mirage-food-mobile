package com.shegs.miragefood.ui.events

import com.shegs.miragefood.models.datas.LoginRequest

sealed interface SignInEvents {
   data class SignInClicked(val loginRequest: LoginRequest) : SignInEvents
   object OnSignIn : SignInEvents
   data class OnEmailChange(val email: String) : SignInEvents
   data class OnPasswordChange(val password: String) : SignInEvents
}