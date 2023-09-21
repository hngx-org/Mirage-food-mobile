package com.shegs.miragefood.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.repositories.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) : ViewModel() {

    private val _state = MutableStateFlow(OnboardingState())
    val state = _state.asStateFlow()

    private val _uiEventFlow = MutableSharedFlow<OnboardingUiEvents>()
    val uiEventFlow = _uiEventFlow.asSharedFlow()

    init {
        readOnboardingState()
    }

    private fun readOnboardingState() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
//                    isUserLoggedIn = onboardingRepository.readOnboardingState().stateIn(this).value
                )
            }
            delay(100)
            if (_state.value.isUserLoggedIn) {
                _uiEventFlow.emit(OnboardingUiEvents.SkipOnBoarding)
            } else {
                _state.update {
                    it.copy(showOptions = true)
                }
            }
        }
    }

    fun onEvent(event: OnboardingEvents) {
        when (event) {
            OnboardingEvents.OnSignInClick -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(OnboardingUiEvents.NavigateToSignIn)
                }
            }

            OnboardingEvents.OnSignUpClick -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(OnboardingUiEvents.NavigateToSignUp)
                }
            }
        }
    }

}