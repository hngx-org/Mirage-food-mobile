package com.shegs.miragefood.ui.events

import com.shegs.miragefood.models.datas.LoginRequest

sealed class SignInEvents {
   data class SignInClicked(val loginRequest: LoginRequest) : SignInEvents()
}