package com.shegs.miragefood.ui.screens.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {

    fun onEvent(event: SignUpEvents) {
        when (event) {
            SignUpEvents.OnSignUpClicked -> {
                // TODO()
            }
        }
    }

}