package com.shegs.miragefood.ui.states

import com.shegs.miragefood.services.Lunch

data class GetAllLunchState(
    var lunch: List<Lunch> = emptyList(),
    val loading: Boolean = false,
    val isLoaded: Boolean = false,
)