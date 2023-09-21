package com.shegs.miragefood.models.repositories

import androidx.compose.ui.text.toLowerCase
import com.shegs.miragefood.R
import com.shegs.miragefood.models.datas.Employee
import kotlinx.coroutines.delay


class SearchRepository {


    suspend fun searchEmployees(text: String): List<Employee>{
        // Simulates network delay
        delay(1000L)
        // TODO Replace with call to API
        return employees.filter {
            it.name.lowercase().contains(text)
        }
    }
}

// Dummy data for testing
val employees = listOf(
    Employee(
        name = "Ayodeji Musa",
        department = "HR Department",
        image = R.drawable.user1
    ),
    Employee(
        name = "Bisola Dabo",
        department = "Marketing Department",
        image = R.drawable.user2
    )
)