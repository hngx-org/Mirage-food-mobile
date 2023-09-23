package com.shegs.miragefood.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.repositories.LunchRepository
import com.shegs.miragefood.repositories.OnboardingRepository
import com.shegs.miragefood.ui.events.GetAllLunchEvents
import com.shegs.miragefood.ui.states.GetAllLunchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class LunchViewModel @Inject constructor(
    private val repository: LunchRepository,
    private val onboardingRepository: OnboardingRepository
) : ViewModel() {

    private val _lunchState = MutableStateFlow<GetAllLunchState>(GetAllLunchState.Initial)
    val lunchState: StateFlow<GetAllLunchState> = _lunchState


    init {
       readToken()
    }

    private fun readToken(){
        viewModelScope.launch {
           val token = onboardingRepository.readLoginData().stateIn(this).value
            getLunch(GetAllLunchEvents.GetAllLunch(token = token))
        }
    }

    fun getLunch(event: GetAllLunchEvents) {
        when (event) {
            is GetAllLunchEvents.GetAllLunch -> {
                viewModelScope.launch {
                    _lunchState.emit(GetAllLunchState.Loading)
                    try {
                        val response = repository.getAllLunch(event.token)

                        if (response.isSuccessful && response.body() != null) {
                            _lunchState.emit(GetAllLunchState.Success(lunch = response.body()!!))
                            Log.i("Lunch RESP", response.body()!!.toString())
                        } else {
                            _lunchState.emit(
                                GetAllLunchState.Error(detail = response.body()!!.toString())
                            )
                            Log.i("Lunch RESP", response.body()!!.toString())
                        }
                    } catch (e: Exception) {
                        _lunchState.emit(
                            GetAllLunchState.Error(detail = e.message.toString())
                        )
                    }
                }
            }
        }
    }

}