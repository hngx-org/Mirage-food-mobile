package com.shegs.miragefood.ui.events

sealed class GetAllLunchEvents {
    data class GetAllLunch(val token: String) : GetAllLunchEvents()
}