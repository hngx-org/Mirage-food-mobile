package com.shegs.miragefood.ui.events

sealed interface SearchScreenUiEvents {
    data class ShowSnackBar(val message: String) : SearchScreenUiEvents
}