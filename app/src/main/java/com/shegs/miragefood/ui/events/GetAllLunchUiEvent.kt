package com.shegs.miragefood.ui.events

sealed interface GetAllLunchUiEvent {
    data class ShowSnackBar(val message: String) : GetAllLunchUiEvent
}