package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import com.shegs.miragefood.models.datas.Transaction
import com.shegs.miragefood.models.repositories.TransactionRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class TransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    val transactions: StateFlow<List<Transaction>> = transactionRepository.transactions
}