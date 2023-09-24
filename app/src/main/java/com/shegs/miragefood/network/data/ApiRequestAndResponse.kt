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

