package com.shegs.miragefood.network.data

data class SignUpRequest(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String,
    val phone_number: String
)

data class SignUpResponse(
    val email: String,
    val first_name: String,
    val last_name: String,
    val phone: String?
)

data class SignInRequest(
    val email: String,
    val password: String
)

data class SignInResponse(
    val message: String,
    val statusCode: Int,
    val data: UserData
)
data class UserData(
    val access_token: String,
    val email: String,
    val id: String,
    val isAdmin: Boolean
)
