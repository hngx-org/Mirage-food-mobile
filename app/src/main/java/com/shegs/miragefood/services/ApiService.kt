package com.shegs.miragefood.services

import com.shegs.miragefood.models.datas.LoginRequest
import com.shegs.miragefood.models.datas.Lunch
import com.shegs.miragefood.models.datas.User
import com.shegs.miragefood.network.data.SignUpRequest
import com.shegs.miragefood.network.data.SignUpResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("api/auth/user/signup")
    fun signUp(@Body requestBody: SignUpRequest): Call<SignUpResponse>

    @POST("api/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<User>

    @GET("api/lunch/all")
    suspend fun getLunch(@Header("Authorization") token: String): Response<List<Lunch>>

}