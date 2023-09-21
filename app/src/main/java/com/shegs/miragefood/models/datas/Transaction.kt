package com.shegs.miragefood.models.datas

sealed class Transaction {
    abstract val timestamp: Long
}

data class ReceivedTransaction(
    val sender: String,
    val amountSent: Int,
    val message: String,
    override val timestamp: Long
) : Transaction()

data class RedeemedTransaction(
    val redeemedAmount: Int,
    override val timestamp: Long
) : Transaction()

data class WithdrawnTransaction(
    val withdrawnAmount: Int,
    override val timestamp: Long
) : Transaction()


