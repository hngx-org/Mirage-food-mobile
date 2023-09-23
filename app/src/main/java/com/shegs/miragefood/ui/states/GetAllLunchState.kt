package com.shegs.miragefood.ui.states

import com.shegs.miragefood.models.datas.Lunch

sealed class GetAllLunchState {
    object Initial : GetAllLunchState()
    object Loading : GetAllLunchState()
    data class Success(var lunch: List<Lunch>) : GetAllLunchState()
    data class Error(var detail: String) : GetAllLunchState()
}