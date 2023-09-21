package com.shegs.miragefood.ui.screens.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.utils.ValidationEvent
import com.shegs.miragefood.utils.validateEmail
import com.shegs.miragefood.utils.validatePassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(SignInFormState())
    val state = _state.asStateFlow()

    //use shared flow if there are multiple observers on same flow i.e multiple screes
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun formEvent(event: SignInFormEvent) {
        when (event) {
            is SignInFormEvent.SignInClicked -> {
                val emailResult = _state.value.email.validateEmail()
                val passwordResult = _state.value.password.validatePassword()

                val hasError = listOf(emailResult, passwordResult).any { !it.successful }

                if (hasError) {
                    _state.update {
                        it.copy(
                            emailError = emailResult.errorMessage,
                            passwordError = passwordResult.errorMessage,
                        )
                    }
                    return
                }
                viewModelScope.launch {
                    validationEventChannel.send(ValidationEvent.Success)
                }
            }

            is SignInFormEvent.EmailChanged -> {
                _state.update { it.copy(email = event.email) }
            }

            is SignInFormEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.password) }

            }
        }
    }
}