package com.shegs.miragefood.ui.screens.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.utils.ValidationEvent
import com.shegs.miragefood.utils.validateEmail
import com.shegs.miragefood.utils.validateFullName
import com.shegs.miragefood.utils.validatePassword
import com.shegs.miragefood.utils.validateRepeatedPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(SignUpFormState())
    val state = _state.asStateFlow()

    //use shared flow if there are multiple observers on same flow i.e multiple screes
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()
    fun formEvent(event: SignUpFormEvent) {
        when (event) {
            is SignUpFormEvent.EmailChanged -> {
                _state.update { it.copy(email = event.email) }
            }

            is SignUpFormEvent.FullNameChanged -> {
                _state.update { it.copy(fullName = event.fullName) }
            }

            is SignUpFormEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.password) }
            }

            is SignUpFormEvent.RepeatedPasswordChanged -> {
                _state.update { it.copy(repeatedPassword = event.repeatedPassword) }
            }

            is SignUpFormEvent.RememberPassword -> {
                _state.update { it.copy(rememberPassword = event.rememberPassword) }
            }

            SignUpFormEvent.OnSignUpClicked -> {
               signUp()
            }
        }
    }
    private fun signUp() {
        val fullNameResult = _state.value.fullName.validateFullName()
        val emailResult = _state.value.email.validateEmail()
        val passwordResult = _state.value.password.validatePassword()
        val repeatedPasswordResult =
            _state.value.repeatedPassword.validateRepeatedPassword(_state.value.password)

        val hasError = listOf(
            fullNameResult,
            emailResult,
            passwordResult,
            repeatedPasswordResult
        ).any { !it.successful }

        if (hasError) {
            _state.update {
                it.copy(
                    fullNameError = fullNameResult.errorMessage,
                    emailError = emailResult.errorMessage,
                    passwordError = passwordResult.errorMessage,
                    repeatedPasswordError = repeatedPasswordResult.errorMessage
                )
            }
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }
}