//package com.shegs.miragefood.models.repositories
//
//import com.shegs.miragefood.models.datas.Transaction
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import javax.inject.Inject
//
//class OnboardingRepository @Inject constructor() {
//    private val _onboardingItems = MutableStateFlow<List<Transaction>>(emptyList())
//    val transactions: StateFlow<List<Transaction>> = _transactions
//}