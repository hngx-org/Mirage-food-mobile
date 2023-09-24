package com.shegs.miragefood.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.repositories.LunchRepository
import com.shegs.miragefood.repositories.DataStoreRepository
import com.shegs.miragefood.repositories.Resource
import com.shegs.miragefood.ui.events.GetAllLunchUiEvent
import com.shegs.miragefood.ui.states.GetAllLunchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LunchViewModel @Inject constructor(
    private val repository: LunchRepository,
    private val dataStoreRepository: DataStoreRepository,
) : ViewModel() {

    private val _lunchState = MutableStateFlow(GetAllLunchState())
    val lunchState = _lunchState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<GetAllLunchUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

     fun getLunch() {
        viewModelScope.launch(Dispatchers.IO) {
                repository.getAllLunch(
                    "Bearer " + dataStoreRepository.readAccessToken().stateIn(this).value
                ).onEach { result ->
                    when (result) {
                        is Resource.Error -> {
                            _lunchState.update {
                                it.copy(loading = false)
                            }
                            _eventFlow.emit(
                                GetAllLunchUiEvent.ShowSnackBar(
                                    result.errorMessage ?: ""
                                )
                            )
                        }

                        is Resource.Loading -> {
                            _lunchState.update {
                                it.copy(loading = true)
                            }
                        }

                        is Resource.Success -> {
                            _lunchState.update {
                                it.copy(
                                    loading = false,
                                    isLoaded = true,
                                    lunch = result.data?.data ?: emptyList()
                                )
                            }
                            _eventFlow.emit(
                                GetAllLunchUiEvent.ShowSnackBar(
                                    "Successfully Fetched"
                                )
                            )
                            Log.i("lunchhh", result.data?.data.toString())
                        }

                        else -> {}
                    }
                }.launchIn(this)
        }
    }

}