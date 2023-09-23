package com.shegs.miragefood.ui.states

import com.shegs.miragefood.models.datas.User

sealed class SignInState{
    object Initial:SignInState()
    object Loading:SignInState()
    data class Success(val user: User): SignInState()
    data class Error(val detail:String) : SignInState()

}


