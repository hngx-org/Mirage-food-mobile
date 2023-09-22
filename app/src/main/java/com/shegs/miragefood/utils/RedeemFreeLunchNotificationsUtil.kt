package com.shegs.miragefood.utils

import com.shegs.miragefood.models.datas.RedeemLunchNotification


fun generateRedeemFreeLunchNotifications(): List<RedeemLunchNotification> {
    val currentTimeMillis = System.currentTimeMillis()

    val redeemLunchNotification = RedeemLunchNotification(
        timeStamp = currentTimeMillis,
        lunchCount = "2",
        lunchSender = "Fola"
    )
    val redeemLunchNotification2 = RedeemLunchNotification(
        timeStamp = currentTimeMillis,
        lunchCount = "3",
        lunchSender = "Folu"
    )



    return listOf(
        redeemLunchNotification,
        redeemLunchNotification2,
    )
}
