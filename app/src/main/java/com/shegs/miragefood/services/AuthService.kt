package com.shegs.miragefood.services

import com.shegs.miragefood.models.datas.LoginRequest
import com.shegs.miragefood.models.datas.User
import retrofit2.Response
import retrofit2.http.POST


interface AuthService {
    @POST("auth/login")
    suspend fun login(loginRequest: LoginRequest): Response<User>
}