package com.shegs.miragefood.models.repositories

import com.shegs.miragefood.R
import com.shegs.miragefood.models.datas.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserDataRepository @Inject constructor() {

    // Simulated data source
    private val userData = MutableStateFlow(UserData(name = "Amy", img = R.drawable.user_image, redeemedBalance = 0))

    fun getUserData(): StateFlow<UserData?> {
        return userData
    }

}