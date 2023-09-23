package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.repositories.SignInRepository
import com.shegs.miragefood.ui.events.SignInEvents
import com.shegs.miragefood.ui.states.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val signInRepository: SignInRepository
) : ViewModel() {

    private val _signInstate = MutableStateFlow<SignInState>(SignInState.Initial)
    val signInState: StateFlow<SignInState> = _signInstate

    fun onEvent(event: SignInEvents) {
        when (event) {
            is SignInEvents.SignInClicked -> {
                viewModelScope.launch {
                    _signInstate.value = SignInState.Loading
                    try {
                        val response = signInRepository.login(
                            event.loginRequest.copy(
                                email = event.loginRequest.email,
                                password = event.loginRequest.password
                            )
                        )

                        if (response.isSuccessful && response.body() != null) {
                            _signInstate.value = SignInState.Success(user = response.body()!!)
                        } else {
                            _signInstate.value =
                                SignInState.Error(detail = response.body()!!.toString())
                        }
                    } catch (e: Exception) {
                        _signInstate.value =
                            SignInState.Error(detail = "Login Failed")
                    }
                }
            }
        }
    }
}