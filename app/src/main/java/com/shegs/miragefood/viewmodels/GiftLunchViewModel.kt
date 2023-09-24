package com.shegs.miragefood.viewmodels


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GiftLunchViewModel @Inject constructor() : ViewModel() {

    private var _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

    fun setShowBottomSheet(showBottomSheet: Boolean) {
        _showBottomSheet.value = showBottomSheet
    }
}