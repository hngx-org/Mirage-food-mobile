package com.shegs.miragefood.viewmodels


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FreeLunchViewModel : ViewModel() {

    private var _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet: StateFlow<Boolean>  = _showBottomSheet


      fun setShowBottomSheet(showBottomSheet:Boolean){
          _showBottomSheet.value = showBottomSheet
      }
}