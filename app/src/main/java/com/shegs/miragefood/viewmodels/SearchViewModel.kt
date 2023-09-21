package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.datas.SearchUIState
import com.shegs.miragefood.models.repositories.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel@Inject constructor(
    private val searchRepo: SearchRepository
): ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _searchUIState = MutableStateFlow<SearchUIState>(SearchUIState.Idle)
    val searchUIState = _searchUIState.asStateFlow()

    private var searchJob: Job? = null



    fun onSearchTextChange(text: String){
        _searchText.value = text
        // Creates a delay to avoid making too many network calls
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(400L)
            if (text.isNotBlank()){
                searchEmployees(text)
            }
        }
    }

    private suspend fun searchEmployees(text: String){
        _searchUIState.update { SearchUIState.Loading }
        try {
            val result = searchRepo.searchEmployees(text)
            if (result.isEmpty()){
                _searchUIState.update { SearchUIState.Empty }
            }else{
                _searchUIState.update { SearchUIState.Success(result) }
            }
        } catch(e: Exception){
            _searchUIState.update { SearchUIState.Error(e.message?:"Unknown error") }
        }
    }
}