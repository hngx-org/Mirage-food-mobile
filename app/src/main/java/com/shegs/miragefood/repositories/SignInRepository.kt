package com.shegs.miragefood.repositories

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.shegs.miragefood.models.datas.LoginRequest
import com.shegs.miragefood.models.datas.User
import com.shegs.miragefood.services.ApiService
import retrofit2.Response
import javax.inject.Inject

class SignInRepository @Inject constructor(
    private val authService: ApiService,
) {
    suspend fun login(userDetails: LoginRequest): Response<User> {
        val loginRequest = LoginRequest(email = userDetails.email, password = userDetails.password)
        return authService.login(loginRequest)

    }


}