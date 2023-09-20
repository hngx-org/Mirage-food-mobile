package com.shegs.miragefood.utils

import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.models.datas.RedeemedTransaction
import com.shegs.miragefood.models.datas.Transaction
import com.shegs.miragefood.models.datas.WithdrawnTransaction

fun generateSampleTransactions(): List<Transaction> {
    val currentTimeMillis = System.currentTimeMillis()

    val receivedTransaction1 = ReceivedTransaction(
        sender = "Shegs Boss",
        amountSent = 2, // Amount of lunch sent
        timestamp = currentTimeMillis,
    )

    val redeemedTransaction1 = RedeemedTransaction(
        redeemedAmount = 4, // Redeemed 1000 lunch
        timestamp = currentTimeMillis
    )

    val withdrawnTransaction1 = WithdrawnTransaction(
        withdrawnAmount = 2000, // Withdrew 2000 lunch as cash
        timestamp = currentTimeMillis
    )

    val receivedTransaction2 = ReceivedTransaction(
        sender = "John Wick",
        amountSent = 1, // Amount of lunch sent
        timestamp = currentTimeMillis
    )

    val redeemedTransaction2 = RedeemedTransaction(
        redeemedAmount = 2, // Redeemed 1000 lunch
        timestamp = currentTimeMillis
    )

    val withdrawnTransaction2 = WithdrawnTransaction(
        withdrawnAmount = 4000, // Withdrew 2000 lunch as cash
        timestamp = currentTimeMillis
    )

    val receivedTransaction3 = ReceivedTransaction(
        sender = "Victor Amanda",
        amountSent = 3, // Amount of lunch sent
        timestamp = currentTimeMillis
    )

    val redeemedTransaction3 = RedeemedTransaction(
        redeemedAmount = 4, // Redeemed 1000 lunch
        timestamp = currentTimeMillis
    )

    val withdrawnTransaction3 = WithdrawnTransaction(
        withdrawnAmount = 1000, // Withdrew 2000 lunch as cash
        timestamp = currentTimeMillis
    )

    // Add more transactions as needed

    return listOf(
        receivedTransaction1,
        redeemedTransaction1,
        withdrawnTransaction1,
        receivedTransaction2,
        redeemedTransaction2,
        withdrawnTransaction2,
        receivedTransaction3,
        redeemedTransaction3,
        withdrawnTransaction3
        // Add more transactions here
    )
}
