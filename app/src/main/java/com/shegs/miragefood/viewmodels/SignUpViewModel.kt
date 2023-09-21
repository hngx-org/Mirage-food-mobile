package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import com.shegs.miragefood.ui.events.SignUpEvents
import javax.inject.Inject

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