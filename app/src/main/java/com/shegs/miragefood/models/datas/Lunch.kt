package com.shegs.miragefood.models.datas


data class LunchData(
    val message: String,
    val statusCode: String,
    val data: List<Lunch>,
)

data class Lunch(
    val receiverId: String = "",
    val senderId: String = "",
    val quantity: Int = 0,
    val redeemed: Boolean = false,
    val note: String = "",
    val createdAt: String = "",
    val id: String = "",
)