package com.shegs.miragefood.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.datas.OnboardingItems
import com.shegs.miragefood.repositories.DataStoreRepository
import com.shegs.miragefood.repositories.OnboardingRepository
import com.shegs.miragefood.ui.events.OnboardingEvent
import com.shegs.miragefood.ui.events.OnboardingUiEvent
import com.shegs.miragefood.ui.events.SplashUiEvent
import com.shegs.miragefood.ui.states.OnboardingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    onboardingRepository: OnboardingRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {
    val onboardingPages: StateFlow<List<OnboardingItems>> = onboardingRepository.onboardingItems

    private var _pageIndex = MutableStateFlow(0)
    val pageIndex: StateFlow<Int> = _pageIndex

    fun retrieveOnboardingPages(): List<OnboardingItems> {
        return onboardingPages.value
    }

    fun observePageIndex(pagerStateFlow: Int) {
        Log.d("pagerstateflow", pagerStateFlow.toString())
    }

    private val _state = MutableStateFlow(OnboardingState())
    val state = _state.asStateFlow()

    private val _onboardingEventFlow = MutableSharedFlow<OnboardingUiEvent>()
    val onboardingEventFlow = _onboardingEventFlow.asSharedFlow()

    private val _splashEventFlow = MutableSharedFlow<SplashUiEvent>()
    val splashEventFlow = _splashEventFlow.asSharedFlow()


    init {
        readOnboardingState()
    }

    private fun readOnboardingState() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    isUserOnboarded = dataStoreRepository.readOnboardingState().stateIn(this).value
                )
            }
            delay(2000L)
            if (_state.value.isUserOnboarded) {
                _splashEventFlow.emit(SplashUiEvent.SkipOnBoarding)
            } else {
                _splashEventFlow.emit(SplashUiEvent.ShowOnBoarding)
            }
        }
    }

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.OnSignInClick -> {
                viewModelScope.launch {
                    _onboardingEventFlow.emit(OnboardingUiEvent.NavigateToSignIn)
                }
            }

            OnboardingEvent.OnSignUpClick -> {
                viewModelScope.launch {
                    _onboardingEventFlow.emit(OnboardingUiEvent.NavigateToSignUp)
                }
            }
        }
    }

}