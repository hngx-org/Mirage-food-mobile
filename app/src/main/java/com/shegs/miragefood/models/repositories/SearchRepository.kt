package com.shegs.miragefood.models.repositories

import com.shegs.miragefood.models.datas.Employee
import kotlinx.coroutines.delay


class SearchRepository {


    suspend fun searchEmployees(text: String): List<Employee>{
        // Simulates network delay
        delay(1000L)
        // Return the result from the API
        return emptyList()
    }
}