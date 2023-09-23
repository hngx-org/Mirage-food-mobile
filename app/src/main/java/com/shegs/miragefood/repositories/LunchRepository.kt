package com.shegs.miragefood.models.repositories

import com.shegs.miragefood.models.datas.Lunch
import com.shegs.miragefood.services.ApiService
import retrofit2.Response
import javax.inject.Inject

class LunchRepository @Inject constructor(
    private val apiService: ApiService
) {
   suspend  fun getAllLunch(token: String): Response<List<Lunch>> {
        return apiService.getLunch(token = token);
    }
}