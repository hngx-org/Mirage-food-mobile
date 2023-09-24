package com.shegs.miragefood.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.repositories.DataStoreRepository
import com.shegs.miragefood.repositories.NetworkRepository
import com.shegs.miragefood.repositories.Resource
import com.shegs.miragefood.ui.events.SearchScreenEvent
import com.shegs.miragefood.ui.events.SearchScreenUiEvents
import com.shegs.miragefood.ui.states.SearchScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SearchScreenState())
    val state = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<SearchScreenUiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    init {
        getAllUsers()
    }

    fun onEvent(event: SearchScreenEvent) {
        when (event) {
            SearchScreenEvent.OnSearch -> {
                searchForUser(_state.value.query)
            }

            is SearchScreenEvent.SearchQueryChanged -> {
                _state.update { it.copy(query = event.query) }
            }

            is SearchScreenEvent.OnItemClicked -> {
                // ToDO()
            }
        }
    }

    private fun searchForUser(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            networkRepository.getUserByQuery(
                query = query,
                accessToken = " Bearer " + dataStoreRepository.readAccessToken().stateIn(this).value
            ).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.update { it.copy(loading = false) }
                        _eventFlow.emit(
                            SearchScreenUiEvents.ShowSnackBar(
                                result.data?.message ?: "An error occurred"
                            )
                        )
                    }

                    is Resource.Loading -> {
                        _state.update { it.copy(loading = true, isSearching = true) }
                    }

                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                loading = false,
                                searchResults = result.data?.data ?: emptyList()
                            )
                        }
                        _eventFlow.emit(
                            SearchScreenUiEvents.ShowSnackBar(
                              "Success"
                            )
                        )
                    }
                }
            }.launchIn(this)
        }
    }

    private fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            networkRepository.getAllUsers(
                accessToken = "Bearer " + dataStoreRepository.readAccessToken().stateIn(this).value
            )
                .onEach { result ->
                    when (result) {
                        is Resource.Error -> {
                            _state.update { it.copy(loading = false) }
                            _eventFlow.emit(
                                SearchScreenUiEvents.ShowSnackBar(
                                    result.data?.message ?: "An error occurred"
                                )
                            )
                        }

                        is Resource.Loading -> {
                            _state.update { it.copy(loading = true, isSearching = false) }
                        }

                        is Resource.Success -> {
                            _state.update {
                                it.copy(
                                    loading = false,
                                    allUsers = result.data?.data ?: emptyList()
                                )
                            }
                            _eventFlow.emit(
                                SearchScreenUiEvents.ShowSnackBar(
                                    "Success"
                                )
                            )
                            Log.i("SEARCH RESP", result.data?.data.toString())
                        }
                    }
                }.launchIn(this)
        }
    }
}