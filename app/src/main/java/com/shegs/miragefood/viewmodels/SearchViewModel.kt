package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.datas.Employee
import com.shegs.miragefood.models.datas.SearchUIState
import com.shegs.miragefood.models.repositories.SearchRepository
import com.shegs.miragefood.ui.screens.SearchScreen
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(FlowPreview::class)
class SearchViewModel@Inject constructor(
    private val searchRepo: SearchRepository
): ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    val searchUIState = searchText
        .debounce(500L)
        .onStart {
            SearchUIState.Loading
        }
        .map { text->
            searchEmployees(text)
        }
        .catch { throwable ->
            SearchUIState.Error(message = throwable.message ?: "Unknown error occurred")
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            SearchUIState.Idle
        )



    fun onSearchTextChange(text: String){
        _searchText.value = text
    }

    private suspend fun searchEmployees(text: String): SearchUIState{
        val result = searchRepo.searchEmployees(text)
        return if (result.isEmpty()){
            SearchUIState.Empty
        }else{
            SearchUIState.Success(result)
        }
    }
}

val employees = listOf(
    Employee(
        name = "Ayodeji Musa",
        image = 1,
        department = "HR Department"
    ),
    Employee(
        name = "Bisola Dabo",
        image = 2,
        department = "Marketing Department"
    )
)