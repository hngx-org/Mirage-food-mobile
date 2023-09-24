package com.shegs.miragefood.repositories

import com.shegs.miragefood.models.datas.OnboardingItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class OnboardingRepository @Inject constructor(

) {

    private val _onboardingItems = MutableStateFlow<List<OnboardingItems>>(emptyList())
    val onboardingItems: StateFlow<List<OnboardingItems>> = _onboardingItems

    init {
        // Fetch or load data from an actual data source here
        // For simplicity, you can use your sample data here
        _onboardingItems.value = listOf(
            OnboardingItems.First,
            OnboardingItems.Second,
            OnboardingItems.Third
        )
    }

}