package com.shegs.miragefood.services

import com.shegs.miragefood.network.data.SignUpRequest
import com.shegs.miragefood.network.data.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface FreeLunchApiService {

    @POST("auth/user/signup")
    fun signUp(@Body requestBody: SignUpRequest): Call<SignUpResponse>

    @POST("auth/login")
    suspend fun login(@Body signInRequest: SignInRequest): CustomResponse<LoginResponse>

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("user/all")
    suspend fun getAllUsers(
        @Header("Authorization") accessToken: String
    ): CustomResponse<UserInfo>

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("user/search/{query}")
    suspend fun getUserByQuery(
        @Query("query") query: String,
        @Header("Authorization") accessToken: String
    ): CustomResponse<UserInfo>
}

data class CustomResponse<T>(
    val message: String,
    val statusCode: Int,
    val data: List<T>
)

data class UserInfo(
    val name: String?,
    val email: String?,
    val profile_picture: String?,
    val user_id: String?,
)

data class SignInRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val access_token: String,
    val email: String,
    val id: String,
    val isAdminn: Boolean
)