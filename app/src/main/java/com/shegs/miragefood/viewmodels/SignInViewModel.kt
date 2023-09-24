package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.repositories.DataStoreRepository
import com.shegs.miragefood.repositories.NetworkRepository
import com.shegs.miragefood.repositories.Resource
import com.shegs.miragefood.services.SignInRequest
import com.shegs.miragefood.ui.events.SignInEvents
import com.shegs.miragefood.ui.events.SignInUiEvents
import com.shegs.miragefood.ui.states.SignInState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<SignInUiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: SignInEvents) {
        when (event) {
            is SignInEvents.OnEmailChange -> {
                _state.update { it.copy(email = event.email) }
            }

            is SignInEvents.OnPasswordChange -> {
                _state.update { it.copy(password = event.password) }
            }

            SignInEvents.OnSignIn -> {
                signIn(
                    SignInRequest(
                        email = _state.value.email,
                        password = _state.value.password
                    )
                )
            }

            is SignInEvents.SignInClicked -> TODO()
        }
    }

    private fun signIn(signInRequest: SignInRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            networkRepository.signIn(signInRequest).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.update { it.copy(loading = false) }
                        _eventFlow.emit(
                            SignInUiEvents.ShowSnackBar(
                                result.errorMessage ?: "An error occurred"
                            )
                        )
                    }

                    is Resource.Loading -> {
                        _state.update { it.copy(loading = true) }
                    }

                    is Resource.Success -> {
                        _state.update { it.copy(loading = false) }
                        dataStoreRepository.saveAccessToken(
                            result.data?.body()?.access ?: ""
                        )
                        _eventFlow.emit(SignInUiEvents.ShowSnackBar("Login successful"))
                        delay(1500)
                        _eventFlow.emit(SignInUiEvents.OnsuccessfulSignIn)
                    }
                }
            }.launchIn(this)
        }
    }
}