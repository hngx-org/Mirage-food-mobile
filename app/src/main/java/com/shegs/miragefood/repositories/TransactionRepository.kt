package com.shegs.miragefood.repositories

import com.shegs.miragefood.models.datas.Transaction
import com.shegs.miragefood.utils.generateSampleTransactions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TransactionRepository @Inject constructor() {

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    init {
        // Fetch or load data from an actual data source here
        // For simplicity, you can use your sample data here
        _transactions.value = generateSampleTransactions()
    }

    // Additional functions to update and fetch data from external sources
}