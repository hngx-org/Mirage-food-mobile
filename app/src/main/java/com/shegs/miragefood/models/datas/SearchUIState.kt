package com.shegs.miragefood.models.datas

sealed interface SearchUIState{
    object Loading : SearchUIState
    object Empty : SearchUIState
    object Idle : SearchUIState
    data class Error(val message: String) : SearchUIState
    data class Success(val employees: List<Employee>) : SearchUIState
}
