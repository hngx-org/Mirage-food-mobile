package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import com.shegs.miragefood.models.datas.RedeemLunchNotification
import com.shegs.miragefood.repositories.RedeemLunchNotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RedeemLunchNotificationsViewModel @Inject constructor(
    private val repository: RedeemLunchNotificationRepository
) : ViewModel() {
    val redeemLunchNotificatinos: StateFlow<List<RedeemLunchNotification>> = repository.freeLunchNotification

}