package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import com.shegs.miragefood.models.datas.OnboardingItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class OnboardingViewModel @Inject constructor() : ViewModel() {
    val onboardingPages =
        listOf(
            OnboardingItems.First,
            OnboardingItems.Second,
            OnboardingItems.Third
        )

    private var _pageIndex = MutableStateFlow(0)
    val pageIndex : StateFlow<Int> = _pageIndex

    fun setIndex(index:Int){
        _pageIndex.value = index
    }



    fun retrieveOnboardingPages(): List<OnboardingItems> {
        return onboardingPages
    }


}