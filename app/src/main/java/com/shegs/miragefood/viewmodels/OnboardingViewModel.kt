package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import com.shegs.miragefood.models.datas.OnboardingItems
import javax.inject.Inject

class OnboardingViewModel @Inject constructor() : ViewModel() {
    val onboardingPages =
        listOf(
            OnboardingItems.First,
            OnboardingItems.Second,
            OnboardingItems.Third
        )

    fun retrieveOnboardingPages(): List<OnboardingItems> {
        return onboardingPages
    }


}