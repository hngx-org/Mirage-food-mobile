package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import com.shegs.miragefood.models.datas.OnboardingItems
import com.shegs.miragefood.models.repositories.OnboardingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class OnboardingViewModel @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) : ViewModel() {
    val onboardingPages: StateFlow<List<OnboardingItems>> = onboardingRepository.onboardingItems

    private var _pageIndex = MutableStateFlow(0)
    val pageIndex: StateFlow<Int> = _pageIndex

    fun setIndex(index: Int) {
        _pageIndex.value = index
    }


    fun retrieveOnboardingPages(): List<OnboardingItems> {
        return onboardingPages.value
    }


}