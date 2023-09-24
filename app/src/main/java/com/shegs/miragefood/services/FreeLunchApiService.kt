package com.shegs.miragefood.services

import com.shegs.miragefood.network.data.SignUpRequest
import com.shegs.miragefood.network.data.SignUpResponse
import retrofit2.Call
import retrofit2.Response
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
    suspend fun login(@Body signInRequest: SignInRequest): Response<LoginResponse>

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


    @GET("lunch/all")
    suspend fun getLunch(@Header("Authorization") token: String): CustomResponse<Lunch>

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

data class Lunch(
    val receiver_id: String = "",
    val sender_id: String = "",
    val created_at: String = "",
    val updated_at: String = "",
    val quantity: Int = 0,
    val redeemed: Boolean = false,
    val note: String = "",
    val id: String = "",
    val org_id:Int= 0,
)

data class LoginResponse(
    val access: String,
    val refresh: String,
)