package com.shegs.miragefood.models.repositories

import com.shegs.miragefood.models.datas.RedeemLunchNotification
import com.shegs.miragefood.utils.generateRedeemFreeLunchNotifications
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RedeemLunchNotificationRepository @Inject constructor() {
    private val _freeLunchNotification =
        MutableStateFlow<List<RedeemLunchNotification>>(emptyList())
    val freeLunchNotification: StateFlow<List<RedeemLunchNotification>> = _freeLunchNotification

    init {
        _freeLunchNotification.value = generateRedeemFreeLunchNotifications()
    }
}