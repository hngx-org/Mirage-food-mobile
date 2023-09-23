package com.shegs.miragefood.models.datas

data class Lunch(
    val receiverId: String,
    val senderId: String,
    val quantity: Int,
    val redeemed: Boolean,
    val note: String,
    val createdAt: String,
    val id: String,
)