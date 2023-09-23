package com.shegs.miragefood.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.repositories.OnboardingRepository
import com.shegs.miragefood.repositories.SignInRepository
import com.shegs.miragefood.ui.events.SignInEvents
import com.shegs.miragefood.ui.states.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val signInRepository: SignInRepository,
    private val onboardingRepository: OnboardingRepository
) : ViewModel() {

    private var _signInstate = MutableStateFlow<SignInState>(SignInState.Initial)
    val signInState: StateFlow<SignInState> = _signInstate

    fun login(event: SignInEvents) {
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

                        Log.i("LOGIN RESP", response.body()!!.toString())


                        if (response.isSuccessful && response.body() != null) {
                            _signInstate.emit(SignInState.Success(user = response.body()!!))
                            onboardingRepository.saveLoginDataStorePreferences(access = response.body()!!.access)
                            Log.i("LOGIN RESP", response.body()!!.toString())
                        } else {
                            _signInstate.emit(
                                SignInState.Error(detail = response.body()!!.toString())
                            )
                            Log.i("LOGIN RESP", response.body()!!.toString())
                        }
                    } catch (e: Exception) {
                        e.message?.let { Log.i("exception", it) }
                        Log.i("exception", e.message.toString())

                        _signInstate.emit(
                            SignInState.Error(detail = e.message.toString())
                        )
                    }
                }
            }
        }
    }
}