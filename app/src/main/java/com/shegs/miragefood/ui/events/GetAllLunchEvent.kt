package com.shegs.miragefood.ui.events

sealed class GetAllLunchEvents {
    data class GetAllLunch(val token: String) : GetAllLunchEvents()
    data class ShowSnackBar(val message: String) : GetAllLunchEvents()

}