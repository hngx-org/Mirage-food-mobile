package com.shegs.miragefood.models.datas


data class LunchData(
    val message: String,
    val statusCode: String,
    val data: List<Lunch>,
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